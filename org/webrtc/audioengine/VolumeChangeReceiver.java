package org.webrtc.audioengine;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.AsyncTask;
/* loaded from: classes6.dex */
public class VolumeChangeReceiver extends BroadcastReceiver {
    private static final String TAG = "[VolumeChangeReceiver]";
    private static final String VOLUME_CHANGED_ACTION = "android.media.VOLUME_CHANGED_ACTION";
    public Context mContext;
    private VolumeChangeListener mVolumeChangeListener;
    private int mPreCallVolume = 0;
    private int mPreMusicVolume = 0;
    private boolean mVolumeChangeRegistered = false;

    public VolumeChangeReceiver(Context context, VolumeChangeListener volumeChangeListener) {
        this.mContext = context;
        this.mVolumeChangeListener = volumeChangeListener;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            if (intent.getAction().equals("android.media.VOLUME_CHANGED_ACTION")) {
                AsyncTask.execute(new Runnable() { // from class: org.webrtc.audioengine.VolumeChangeReceiver.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AudioManager audioManager = (AudioManager) VolumeChangeReceiver.this.mContext.getSystemService("audio");
                        int streamVolume = audioManager.getStreamVolume(0);
                        int streamVolume2 = audioManager.getStreamVolume(3);
                        if (streamVolume != VolumeChangeReceiver.this.mPreCallVolume) {
                            VolumeChangeReceiver.this.mPreCallVolume = streamVolume;
                            VolumeChangeReceiver.this.mVolumeChangeListener.onSystemVolumeChange(VolumeChangeReceiver.this.mPreCallVolume);
                        } else if (streamVolume2 != VolumeChangeReceiver.this.mPreMusicVolume) {
                            VolumeChangeReceiver.this.mPreMusicVolume = streamVolume2;
                            VolumeChangeReceiver.this.mVolumeChangeListener.onSystemVolumeChange(VolumeChangeReceiver.this.mPreMusicVolume);
                        }
                    }
                });
            }
        } catch (Exception e) {
            AudioManagerAndroid.doLog("[VolumeChangeReceiver]VolumeChangeReceiver onReceive failed: " + e.getMessage());
        }
    }

    public void init() {
        AudioManager audioManager = (AudioManager) this.mContext.getSystemService("audio");
        this.mPreCallVolume = audioManager.getStreamVolume(0);
        this.mPreMusicVolume = audioManager.getStreamVolume(3);
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
            this.mContext.registerReceiver(this, intentFilter);
            this.mVolumeChangeRegistered = true;
            AudioManagerAndroid.doLog("[VolumeChangeReceiver]registerVolumeChangeReceiver");
        } catch (Exception e) {
            AudioManagerAndroid.doLog("[VolumeChangeReceiver]VolumeChangeReceiver init failed: " + e.getMessage());
        }
    }

    public void uninit() {
        if (this.mVolumeChangeRegistered) {
            try {
                this.mContext.unregisterReceiver(this);
                this.mVolumeChangeRegistered = false;
                AudioManagerAndroid.doLog("[VolumeChangeReceiver]unregisterVolumeChangeReceiver ");
            } catch (Exception e) {
                AudioManagerAndroid.doLog("[VolumeChangeReceiver]unregisterVolumeChangeReceiver error:" + e.getMessage());
            }
        }
    }
}
