package ren.jiemei.extratest;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    String TAG = MainActivity.class.getCanonicalName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String storageState = Environment.getExternalStorageState();
        //sd卡的状态
        Log.e(TAG, "onCreate: "+storageState );
        Log.e(TAG, "onCreate: "+Environment.MEDIA_MOUNTED );
        //判断是否有sd卡
        boolean equals = Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState());
        Log.e(TAG, "onCreate: "+equals);
        //得到sd卡的路径
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        Log.e(TAG, "onCreate: "+absolutePath );

        //得到内置sd卡内所有的文件
        File file = Environment.getExternalStorageDirectory();
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            Log.e(TAG, "onCreate: "+files[i] );
        }
        long freeSpace = Environment.getExternalStorageDirectory().getFreeSpace();
        long usableSpace = Environment.getExternalStorageDirectory().getUsableSpace();
        long totalSpace = Environment.getExternalStorageDirectory().getTotalSpace();
        Log.e(TAG, "onCreate: 剩余空间大小："+freeSpace/1024/1024+" 可用大小:"+usableSpace/1024/1024+" 总空间大小:"+totalSpace/1024/1024 );

    }
}
