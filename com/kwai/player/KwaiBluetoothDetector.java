package com.kwai.player;

import android.bluetooth.BluetoothA2dp;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
/* loaded from: classes4.dex */
public class KwaiBluetoothDetector {
    private static KwaiBluetoothDetector sBluetoothUtil = null;
    private String TAG = "KwaiBluetoothDetector";
    private final Object mLock = new Object();
    private boolean misInited = false;
    BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    BluetoothHeadset mBluetoothHeadset = null;
    BluetoothA2dp mBluetoothA2dp = null;
    private BluetoothProfile.ServiceListener mProfileListener = new BluetoothProfile.ServiceListener() { // from class: com.kwai.player.KwaiBluetoothDetector.1
        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceConnected(int i, BluetoothProfile bluetoothProfile) {
            synchronized (KwaiBluetoothDetector.this.mLock) {
                if (i == 2) {
                    KwaiBluetoothDetector.this.mBluetoothA2dp = (BluetoothA2dp) bluetoothProfile;
                } else if (i == 1) {
                    KwaiBluetoothDetector.this.mBluetoothHeadset = (BluetoothHeadset) bluetoothProfile;
                }
            }
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceDisconnected(int i) {
            synchronized (KwaiBluetoothDetector.this.mLock) {
                if (i == 2) {
                    KwaiBluetoothDetector.this.mBluetoothA2dp = null;
                } else if (i == 1) {
                    KwaiBluetoothDetector.this.mBluetoothHeadset = null;
                }
            }
        }
    };

    /* loaded from: classes4.dex */
    class KwaiBluetoothDeviceInfo {
        private String mName = null;
        private String mAddress = null;
        private String mDeviceInfo = null;

        KwaiBluetoothDeviceInfo() {
        }

        public String toString() {
            if (this.mName != null) {
                this.mDeviceInfo = "name: " + this.mName;
            }
            if (this.mAddress != null) {
                this.mDeviceInfo += ", address: " + this.mAddress;
            }
            return this.mDeviceInfo;
        }
    }

    public static synchronized KwaiBluetoothDetector getInstance() {
        KwaiBluetoothDetector kwaiBluetoothDetector;
        synchronized (KwaiBluetoothDetector.class) {
            if (sBluetoothUtil == null) {
                sBluetoothUtil = new KwaiBluetoothDetector();
            }
            kwaiBluetoothDetector = sBluetoothUtil;
        }
        return kwaiBluetoothDetector;
    }

    public synchronized void close() {
        if (this.misInited) {
            this.mBluetoothAdapter.closeProfileProxy(2, this.mBluetoothA2dp);
            this.mBluetoothAdapter.closeProfileProxy(1, this.mBluetoothHeadset);
            this.misInited = false;
        }
    }

    public String getBlueToothInfo() {
        KwaiBluetoothDeviceInfo kwaiBluetoothDeviceInfo = new KwaiBluetoothDeviceInfo();
        if (this.mBluetoothAdapter != null && 12 == this.mBluetoothAdapter.getState()) {
            synchronized (this.mLock) {
                if (this.mBluetoothA2dp != null) {
                    for (BluetoothDevice bluetoothDevice : this.mBluetoothA2dp.getConnectedDevices()) {
                        if (this.mBluetoothA2dp.isA2dpPlaying(bluetoothDevice)) {
                            kwaiBluetoothDeviceInfo.mName = bluetoothDevice.getName();
                            kwaiBluetoothDeviceInfo.mAddress = bluetoothDevice.getAddress();
                        }
                    }
                } else if (this.mBluetoothHeadset != null) {
                    for (BluetoothDevice bluetoothDevice2 : this.mBluetoothHeadset.getConnectedDevices()) {
                        if (this.mBluetoothHeadset.isAudioConnected(bluetoothDevice2)) {
                            kwaiBluetoothDeviceInfo.mName = bluetoothDevice2.getName();
                            kwaiBluetoothDeviceInfo.mAddress = bluetoothDevice2.getAddress();
                        }
                    }
                }
            }
        }
        return kwaiBluetoothDeviceInfo.toString();
    }

    public synchronized void init(Context context) {
        if (!this.misInited) {
            this.mBluetoothAdapter.getProfileProxy(context, this.mProfileListener, 2);
            this.mBluetoothAdapter.getProfileProxy(context, this.mProfileListener, 1);
            this.misInited = true;
        }
    }
}
