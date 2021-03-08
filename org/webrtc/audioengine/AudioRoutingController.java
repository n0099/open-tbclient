package org.webrtc.audioengine;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import com.yy.audioengine.MainHandler;
/* loaded from: classes6.dex */
public class AudioRoutingController {
    public static final int AudioOutputRoutingDefault = -1;
    public static final int AudioOutputRoutingEarpiece = 1;
    public static final int AudioOutputRoutingHeadset = 0;
    public static final int AudioOutputRoutingHeadsetBluetooth = 5;
    public static final int AudioOutputRoutingHeadsetNoMic = 2;
    public static final int AudioOutputRoutingLoudspeaker = 4;
    public static final int AudioOutputRoutingSpeakerphone = 3;
    public static final int CMD_FORCE_TO_SPEAKER = 3;
    public static final int CMD_SET_DEFAULT_ROUTING = 4;
    private static final int EVT_BT_SCO = 2;
    private static final int EVT_HEADSET = 1;
    private static final String TAG = "[AudioRoutingController]";
    private final AudioManager mAudioManager;
    private AudioRoutingListener mAudioRoutingListener;
    private Context mContext;
    private PhoneStateListener mPhoneStateListener = null;
    private boolean mBluetoothConnected = false;
    private boolean mHeadsetConnected = false;
    private boolean mIsHeadsetNoMic = false;
    private boolean mIsSpeakPhoneOn = false;
    private boolean mPhoneStateListenerRegistered = false;
    private boolean mIsHeadsetPlugReceiverRegistered = false;
    private int mCurrentRouter = -1;
    private int mTryConnectBtScoTimes = 0;
    private BroadcastReceiver mHeadsetPlugReceiver = new BroadcastReceiver() { // from class: org.webrtc.audioengine.AudioRoutingController.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.hasExtra("state")) {
                int intExtra = intent.getIntExtra("state", 0);
                if (AudioRoutingController.this.mAudioRoutingListener != null) {
                    AudioRoutingController.this.mAudioRoutingListener.onHeadsetState(intExtra);
                }
                if (intExtra == 1) {
                    if (intent.getIntExtra("microphone", -1) == 1) {
                        AudioManagerAndroid.doLog("[AudioRoutingController]Headset w/ mic connected");
                        AudioRoutingController.this.sendEvent(1, 0);
                        AudioRoutingController.this.mIsHeadsetNoMic = false;
                    } else {
                        AudioManagerAndroid.doLog("[AudioRoutingController]Headset w/o mic connected");
                        AudioRoutingController.this.sendEvent(1, 2);
                        AudioRoutingController.this.mIsHeadsetNoMic = true;
                    }
                    AudioRoutingController.this.mHeadsetConnected = true;
                } else if (intExtra == 0) {
                    AudioManagerAndroid.doLog("[AudioRoutingController]Headset disconnected");
                    AudioRoutingController.this.sendEvent(1, -1);
                    AudioRoutingController.this.mHeadsetConnected = false;
                }
            }
        }
    };
    private boolean bluetoothReceiverRegistered = false;
    private BroadcastReceiver bluetoothReceiver = new BroadcastReceiver() { // from class: org.webrtc.audioengine.AudioRoutingController.2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED".equals(intent.getAction())) {
                int intExtra = intent.getIntExtra("android.bluetooth.profile.extra.STATE", 0);
                AudioManagerAndroid.doLog("[AudioRoutingController]BluetoothHeadset.ACTION_CONNECTION_STATE_CHANGED: " + intExtra);
                if (intExtra == 2) {
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: org.webrtc.audioengine.AudioRoutingController.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (AudioRoutingController.this.mAudioRoutingListener != null) {
                                AudioRoutingController.this.mAudioRoutingListener.onBluetoothState(1);
                                AudioRoutingController.this.mBluetoothConnected = true;
                                AudioRoutingController.this.sendEvent(2, 5);
                            }
                        }
                    }, 2000L);
                } else if (intExtra == 0 && AudioRoutingController.this.mAudioRoutingListener != null) {
                    AudioRoutingController.this.mAudioRoutingListener.onBluetoothState(0);
                    AudioRoutingController.this.mBluetoothConnected = false;
                    AudioRoutingController.this.sendEvent(2, -1);
                }
            } else if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(intent.getAction())) {
                int intExtra2 = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
                AudioManagerAndroid.doLog("[AudioRoutingController]BluetoothAdapter.ACTION_STATE_CHANGED: " + intExtra2);
                if (intExtra2 == 10 && AudioRoutingController.this.mAudioRoutingListener != null) {
                    AudioRoutingController.this.mAudioRoutingListener.onBluetoothState(0);
                    AudioRoutingController.this.mBluetoothConnected = false;
                    AudioRoutingController.this.sendEvent(2, -1);
                }
            } else if ("android.media.ACTION_SCO_AUDIO_STATE_UPDATED".equals(intent.getAction())) {
                int intExtra3 = intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -99);
                AudioManagerAndroid.doLog("[AudioRoutingController]bluetooth AudioManager.ACTION_SCO_AUDIO_STATE_UPDATED prev: " + AudioRoutingController.this.scoStateString(intent.getIntExtra("android.media.extra.SCO_AUDIO_PREVIOUS_STATE", -99)) + ", current: " + AudioRoutingController.this.scoStateString(intExtra3));
                if (intExtra3 == 0 && AudioRoutingController.this.mBluetoothConnected && AudioRoutingController.this.mAudioRoutingListener != null && AudioRoutingController.this.mTryConnectBtScoTimes < 3) {
                    AudioRoutingController.this.mAudioRoutingListener.onBluetoothScoState(1);
                    AudioManagerAndroid.doLog("[AudioRoutingController]try reset bluetooth sco, mTryConnectBtScoTimes:" + AudioRoutingController.this.mTryConnectBtScoTimes);
                    AudioRoutingController.access$608(AudioRoutingController.this);
                } else if (intExtra3 == 1) {
                    AudioRoutingController.this.mTryConnectBtScoTimes = 0;
                }
            } else if ("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED".equals(intent.getAction())) {
                int intExtra4 = intent.getIntExtra("android.bluetooth.profile.extra.STATE", -99);
                int intExtra5 = intent.getIntExtra("android.bluetooth.profile.extra.PREVIOUS_STATE", -99);
                BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                AudioManagerAndroid.doLog("[AudioRoutingController]BluetoothHeadset.ACTION_AUDIO_STATE_CHANGED device: " + bluetoothDevice.toString() + ", prev: " + intExtra5 + ",current: " + intExtra4);
                switch (intExtra4) {
                    case 10:
                        AudioManagerAndroid.doLog("[AudioRoutingController]Bluetooth audio device " + bluetoothDevice + " disconnected");
                        return;
                    case 11:
                        AudioManagerAndroid.doLog("[AudioRoutingController]Bluetooth audio device " + bluetoothDevice + " connecting");
                        return;
                    case 12:
                        AudioManagerAndroid.doLog("[AudioRoutingController]Bluetooth audio device " + bluetoothDevice + " connected");
                        return;
                    default:
                        AudioManagerAndroid.doLog("[AudioRoutingController]Bluetooth audio device " + bluetoothDevice + " event, state=" + intExtra4);
                        return;
                }
            }
        }
    };
    private EventHandler mEventHandler = new EventHandler(Looper.getMainLooper());

    static /* synthetic */ int access$608(AudioRoutingController audioRoutingController) {
        int i = audioRoutingController.mTryConnectBtScoTimes;
        audioRoutingController.mTryConnectBtScoTimes = i + 1;
        return i;
    }

    public AudioRoutingController(Context context, AudioRoutingListener audioRoutingListener) {
        this.mContext = context;
        this.mAudioRoutingListener = audioRoutingListener;
        this.mAudioManager = (AudioManager) this.mContext.getSystemService("audio");
    }

    public void init() {
        registerBluetoothReceiver();
        registerHeadsetPlugReceiver();
        registerPhoneStateListener();
    }

    public void uninit() {
        unregisterBluetoothReceiver();
        unRegisterHeadsetPlugReceiver();
        unRegisterPhoneStateListener();
    }

    private boolean isCurrentlyOnMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    private void registerHeadsetPlugReceiver() {
        AudioManagerAndroid.doLog("[AudioRoutingController]registerHeadsetPlugReceiver");
        if (!this.mIsHeadsetPlugReceiverRegistered) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.HEADSET_PLUG");
            this.mContext.registerReceiver(this.mHeadsetPlugReceiver, intentFilter);
            this.mIsHeadsetPlugReceiverRegistered = true;
        }
    }

    private void unRegisterHeadsetPlugReceiver() {
        AudioManagerAndroid.doLog("[AudioRoutingController]unRegisterHeadsetPlugReceiver");
        if (this.mIsHeadsetPlugReceiverRegistered) {
            this.mContext.unregisterReceiver(this.mHeadsetPlugReceiver);
            this.mIsHeadsetPlugReceiverRegistered = false;
        }
    }

    @TargetApi(14)
    private boolean isBluetoothHeadsetConnected() {
        boolean z = false;
        try {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter != null && this.mAudioManager.isBluetoothScoAvailableOffCall()) {
                if (Build.VERSION.SDK_INT >= 14) {
                    if (2 == defaultAdapter.getProfileConnectionState(1)) {
                        z = true;
                    }
                } else if (!BluetoothAdapter.getDefaultAdapter().getBondedDevices().isEmpty()) {
                    z = true;
                }
            }
        } catch (Exception e) {
            AudioManagerAndroid.doLog("[AudioRoutingController]detect bluetooth error: " + e.getMessage());
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String scoStateString(int i) {
        if (i == 0) {
            return "SCO_AUDIO_STATE_DISCONNECTED";
        }
        if (i == 1) {
            return "SCO_AUDIO_STATE_CONNECTED";
        }
        if (i == 2) {
            return "SCO_AUDIO_STATE_CONNECTING";
        }
        if (i == -1) {
            return "SCO_AUDIO_STATE_ERROR";
        }
        return "SCO_NULL";
    }

    private boolean hasPermission(Context context, String str) {
        return context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }

    private void registerBluetoothReceiver() {
        if (!hasPermission(this.mContext, "android.permission.BLUETOOTH") || !hasPermission(this.mContext, "android.permission.BLUETOOTH_ADMIN")) {
            AudioManagerAndroid.doLog("[AudioRoutingController]bluetooth permission failed.");
            return;
        }
        try {
            if (!this.bluetoothReceiverRegistered) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
                intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
                intentFilter.addAction("android.media.ACTION_SCO_AUDIO_STATE_UPDATED");
                this.mContext.registerReceiver(this.bluetoothReceiver, intentFilter);
                this.bluetoothReceiverRegistered = true;
            }
        } catch (Exception e) {
            AudioManagerAndroid.doLog("[AudioRoutingController]registerBluetoothReceiver error, " + e.getMessage());
        }
        if (this.mAudioRoutingListener != null) {
            if (isBluetoothHeadsetConnected()) {
                this.mAudioRoutingListener.onBluetoothState(1);
                this.mBluetoothConnected = true;
            } else {
                this.mAudioRoutingListener.onBluetoothState(0);
                this.mBluetoothConnected = false;
            }
            AudioManagerAndroid.doLog("[AudioRoutingController]registerBluetoothReceiver");
        }
    }

    private void unregisterBluetoothReceiver() {
        if (hasPermission(this.mContext, "android.permission.BLUETOOTH") && hasPermission(this.mContext, "android.permission.BLUETOOTH_ADMIN")) {
            if (isBluetoothScoOn(this.mContext)) {
                startOrStopBluetoothSco(false);
            }
            if (this.bluetoothReceiverRegistered) {
                this.mContext.unregisterReceiver(this.bluetoothReceiver);
                this.bluetoothReceiverRegistered = false;
            }
        }
    }

    private boolean isBluetoothScoOn(Context context) {
        return this.mAudioManager.isBluetoothScoOn();
    }

    private void registerPhoneStateListener() {
        if (isCurrentlyOnMainThread()) {
            AudioManagerAndroid.doLog("[AudioRoutingController]registerPhoneStateListener...run on main thread");
            listenTelState();
            return;
        }
        AudioManagerAndroid.doLog("[AudioRoutingController]registerPhoneStateListener...run on async thread");
        MainHandler.getInstance().post(new Runnable() { // from class: org.webrtc.audioengine.AudioRoutingController.3
            @Override // java.lang.Runnable
            public void run() {
                AudioRoutingController.this.listenTelState();
            }
        });
    }

    private void unRegisterPhoneStateListener() {
        if (isCurrentlyOnMainThread()) {
            AudioManagerAndroid.doLog("[AudioRoutingController]unRegisterPhoneStateListener...run on main thread");
            notListenTelState();
            return;
        }
        AudioManagerAndroid.doLog("[AudioRoutingController]unRegisterPhoneStateListener...run on async thread");
        MainHandler.getInstance().post(new Runnable() { // from class: org.webrtc.audioengine.AudioRoutingController.4
            @Override // java.lang.Runnable
            public void run() {
                AudioRoutingController.this.notListenTelState();
            }
        });
    }

    public void setSpeakerphoneOn(boolean z) {
        this.mAudioManager.setSpeakerphoneOn(z);
        AudioManagerAndroid.doLog("[AudioRoutingController]setSpeakerphoneOn: " + z);
        this.mIsSpeakPhoneOn = z;
        sendEvent(3, z ? 3 : 1);
    }

    public void startOrStopBluetoothSco(boolean z) {
        try {
            if (z) {
                this.mAudioManager.setBluetoothScoOn(true);
                this.mAudioManager.startBluetoothSco();
            } else {
                this.mAudioManager.stopBluetoothSco();
                this.mAudioManager.setBluetoothScoOn(false);
            }
            AudioManagerAndroid.doLog("[AudioRoutingController]startOrStopBluetoothSco: " + z);
        } catch (Exception e) {
            AudioManagerAndroid.doLog("[AudioRoutingController]startOrStopBluetoothSco exception: " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class MediaPhoneStateListener extends PhoneStateListener {
        private boolean mInCall;

        private MediaPhoneStateListener() {
            this.mInCall = false;
        }

        @Override // android.telephony.PhoneStateListener
        public void onCallStateChanged(final int i, final String str) {
            if (AudioRoutingController.this.mPhoneStateListenerRegistered && AudioRoutingController.this.mAudioRoutingListener != null) {
                MainHandler.getInstance().postDelayed(new Runnable() { // from class: org.webrtc.audioengine.AudioRoutingController.MediaPhoneStateListener.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AudioManagerAndroid.doLog("[AudioRoutingController]MediaPhoneStateListener: " + i + ",incomingNumber " + str);
                        switch (i) {
                            case 0:
                                if (MediaPhoneStateListener.this.mInCall) {
                                    MediaPhoneStateListener.this.mInCall = false;
                                    AudioRoutingController.this.mAudioRoutingListener.onPhoneCallState(0);
                                    AudioManagerAndroid.doLog("[AudioRoutingController]MediaPhoneStateListener Not in Call");
                                    return;
                                }
                                return;
                            case 1:
                            case 2:
                                if (!MediaPhoneStateListener.this.mInCall) {
                                    MediaPhoneStateListener.this.mInCall = true;
                                    AudioRoutingController.this.mAudioRoutingListener.onPhoneCallState(1);
                                    AudioManagerAndroid.doLog("[AudioRoutingController]MediaPhoneStateListener in Call");
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                    }
                }, 2000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void listenTelState() {
        try {
            if (this.mPhoneStateListener == null) {
                this.mPhoneStateListenerRegistered = true;
                this.mPhoneStateListener = new MediaPhoneStateListener();
                ((TelephonyManager) this.mContext.getSystemService("phone")).listen(this.mPhoneStateListener, 32);
            }
        } catch (Exception e) {
            AudioManagerAndroid.doLog("[AudioRoutingController]MediaPhoneStateListener listenTelState Error, can't listen, " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notListenTelState() {
        try {
            if (this.mPhoneStateListener != null) {
                ((TelephonyManager) this.mContext.getSystemService("phone")).listen(null, 32);
                this.mPhoneStateListener = null;
                this.mPhoneStateListenerRegistered = false;
            }
        } catch (Exception e) {
            AudioManagerAndroid.doLog("[AudioRoutingController]MediaPhoneStateListener notListenTelState Error, can't listen, " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class EventHandler extends Handler {
        public EventHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null) {
                AudioManagerAndroid.doLog("[AudioRoutingController]EventHandler handleMessage: msg.what: " + message.what + " ,msg.arg1: " + message.arg1 + ", mHeadsetConnected: " + AudioRoutingController.this.mHeadsetConnected + ", mBluetoothConnected:" + AudioRoutingController.this.mBluetoothConnected);
                switch (message.what) {
                    case 1:
                        int i = message.arg1;
                        if (i != -1) {
                            AudioRoutingController.this.onAudioRoutingChanged(message.arg1);
                            return;
                        } else if (i == -1 && AudioRoutingController.this.mBluetoothConnected) {
                            AudioRoutingController.this.onAudioRoutingChanged(5);
                            return;
                        } else {
                            return;
                        }
                    case 2:
                        int i2 = message.arg1;
                        if (i2 != -1) {
                            AudioRoutingController.this.onAudioRoutingChanged(i2);
                            return;
                        } else if (!AudioRoutingController.this.mHeadsetConnected) {
                            AudioRoutingController.this.onAudioRoutingChanged(AudioRoutingController.this.mIsSpeakPhoneOn ? 3 : 1);
                            return;
                        } else {
                            AudioRoutingController.this.onAudioRoutingChanged(AudioRoutingController.this.mIsHeadsetNoMic ? 2 : 0);
                            return;
                        }
                    case 3:
                        int i3 = message.arg1;
                        if (!AudioRoutingController.this.mHeadsetConnected && !AudioRoutingController.this.mBluetoothConnected) {
                            AudioRoutingController.this.onAudioRoutingChanged(i3);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAudioRoutingChanged(int i) {
        if (this.mAudioRoutingListener != null && i != this.mCurrentRouter) {
            AudioManagerAndroid.doLog("[AudioRoutingController]onAudioRoutingChanged: " + getAudioRouteDesc(i));
            this.mAudioRoutingListener.onAudioRoutingChanged(i);
            this.mCurrentRouter = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendEvent(int i, int i2) {
        if (this.mEventHandler != null) {
            this.mEventHandler.sendMessage(this.mEventHandler.obtainMessage(i, i2, 0));
        }
    }

    public int queryAudioOutputRouting() {
        int i;
        try {
            if (this.mBluetoothConnected) {
                i = 5;
            } else if (this.mAudioManager.isWiredHeadsetOn()) {
                i = this.mIsHeadsetNoMic ? 2 : 0;
            } else {
                i = this.mAudioManager.isSpeakerphoneOn() ? 3 : 1;
            }
            return i;
        } catch (Exception e) {
            AudioManagerAndroid.doLog("[AudioRoutingController]querySpeakerStatus exception: " + e.getMessage());
            return -1;
        }
    }

    private String getAudioRouteDesc(int i) {
        switch (i) {
            case -1:
                return "Default";
            case 0:
                return "Headset";
            case 1:
                return "Earpiece";
            case 2:
                return "HeadsetOnly";
            case 3:
                return "Speakerphone";
            case 4:
                return "Loudspeaker";
            case 5:
                return "HeadsetBluetooth";
            default:
                return "Unknown";
        }
    }
}
