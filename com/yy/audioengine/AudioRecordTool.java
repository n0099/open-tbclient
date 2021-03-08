package com.yy.audioengine;

import com.yy.audioengine.Constant;
import com.yy.audioengine.SpeechMsgRecorder;
/* loaded from: classes6.dex */
public class AudioRecordTool implements IFilePlayerNotify, ISpeechMsgRecorderNotify {
    private static String TAG = "[AudioRecordTool]";
    private FilePlayer mAccompanyFilePlayer;
    private IAudioRecordToolNotify mNotify;
    private SpeechMsgRecorder mRecorder;

    public void initWithAccompanyPath(String str) {
        YALog.info(TAG + "initWithAccompanyPath: " + str);
        this.mAccompanyFilePlayer = new FilePlayer();
        this.mAccompanyFilePlayer.enableVolumeNotify(true);
        this.mAccompanyFilePlayer.open(str);
    }

    public void destroy() {
        YALog.info(TAG + "destroy...");
        if (this.mRecorder != null) {
            this.mRecorder.destroy();
            this.mRecorder = null;
        }
        if (this.mAccompanyFilePlayer != null) {
            this.mAccompanyFilePlayer.destroy();
            this.mAccompanyFilePlayer = null;
        }
        this.mNotify = null;
    }

    public void setAudioRecordToolNotify(IAudioRecordToolNotify iAudioRecordToolNotify) {
        YALog.info(TAG + "setAudioRecordToolNotify...");
        this.mNotify = iAudioRecordToolNotify;
    }

    public void startRecord() {
        YALog.info(TAG + "startRecord...");
        if (this.mRecorder != null) {
            this.mRecorder.start(this);
        }
    }

    public void pauseRecord() {
        YALog.info(TAG + "pauseRecord...");
        if (this.mRecorder != null) {
            this.mRecorder.pause();
        }
    }

    public void resumeRecord() {
        YALog.info(TAG + "resumeRecord...");
        if (this.mRecorder != null) {
            this.mRecorder.resume();
        }
    }

    public void stopRecord() {
        YALog.info(TAG + "stopRecord...");
        if (this.mRecorder != null) {
            this.mRecorder.stop();
        }
    }

    public void startPlayAccompany() {
        YALog.info(TAG + "startPlayAccompany...");
        if (this.mAccompanyFilePlayer != null) {
            this.mAccompanyFilePlayer.registerNotify(this);
            this.mAccompanyFilePlayer.play();
            this.mAccompanyFilePlayer.enableLoopPlay(true);
        }
    }

    public void pauseAccompany() {
        YALog.info(TAG + "pauseAccompany...");
        if (this.mAccompanyFilePlayer != null) {
            this.mAccompanyFilePlayer.fakePause();
        }
    }

    public void resumeAccompany() {
        YALog.info(TAG + "resumeAccompany...");
        if (this.mAccompanyFilePlayer != null) {
            this.mAccompanyFilePlayer.resume();
        }
    }

    public void stopAccompany() {
        YALog.info(TAG + "stopAccompany...");
        if (this.mAccompanyFilePlayer != null) {
            this.mAccompanyFilePlayer.stop();
            this.mAccompanyFilePlayer.stopSaver();
        }
    }

    public void seekAccompany(long j) {
        YALog.info(TAG + "seekAccompany...");
        if (this.mAccompanyFilePlayer != null) {
            this.mAccompanyFilePlayer.seek(j);
        }
    }

    public void setVoiceFilePath(String str) {
        YALog.info(TAG + "setVoiceFilePath: " + str);
        if (this.mRecorder != null) {
            this.mRecorder.destroy();
            this.mRecorder = null;
        }
        this.mRecorder = new SpeechMsgRecorder(str, 0, SpeechMsgRecorder.SpeechMsgCodecType.SpeechMsgCodecWav, 600000L);
        this.mRecorder.init();
    }

    public void setAcmpyWavFilePath(String str) {
        YALog.info(TAG + "setAcmpyWavFilePath: " + str);
        if (this.mAccompanyFilePlayer != null) {
            this.mAccompanyFilePlayer.startSaver(str);
        }
    }

    public void setVoiceVolume(int i) {
        if (this.mRecorder != null) {
            this.mRecorder.setVolume(i);
        }
    }

    public void setAccompanyVolume(int i) {
        if (this.mAccompanyFilePlayer != null) {
            this.mAccompanyFilePlayer.setPlayerVolume(i);
        }
    }

    @Override // com.yy.audioengine.IFilePlayerNotify
    public void onPlayerEnd() {
        YALog.info(TAG + "OnPlayerEnd...");
        MainHandler.getInstance().post(new Runnable() { // from class: com.yy.audioengine.AudioRecordTool.1
            @Override // java.lang.Runnable
            public void run() {
                if (AudioRecordTool.this.mNotify != null) {
                    AudioRecordTool.this.mNotify.accompanyPlayEnd();
                }
            }
        });
    }

    @Override // com.yy.audioengine.IFilePlayerNotify
    public void onPlayerVolume(int i, long j, long j2) {
        if (this.mNotify != null) {
            this.mNotify.accompanyPlayVolume(i, j, j2);
        }
    }

    @Override // com.yy.audioengine.ISpeechMsgRecorderNotify
    public void onAudioVolumeVisual(long j, long j2) {
        if (this.mNotify != null) {
            this.mNotify.voiceRecordVolume(j2, j);
        }
    }

    @Override // com.yy.audioengine.ISpeechMsgRecorderNotify
    public void onAudioRecordError(final Constant.AudioDeviceErrorType audioDeviceErrorType) {
        MainHandler.getInstance().post(new Runnable() { // from class: com.yy.audioengine.AudioRecordTool.2
            @Override // java.lang.Runnable
            public void run() {
                if (AudioRecordTool.this.mNotify != null) {
                    AudioRecordTool.this.mNotify.onAudioRecordError(audioDeviceErrorType);
                }
            }
        });
    }

    @Override // com.yy.audioengine.ISpeechMsgRecorderNotify
    public void onGetFirstRecordData() {
        if (this.mNotify != null) {
            this.mNotify.onGetFirstRecordData();
        }
    }

    @Override // com.yy.audioengine.ISpeechMsgRecorderNotify
    public void onStopRecordData(long j, long j2) {
        if (this.mNotify != null) {
            this.mNotify.onStopRecordData(j, j2);
        }
    }

    @Override // com.yy.audioengine.ISpeechMsgRecorderNotify
    public void onReachMaxDuration(long j, long j2) {
        YALog.info(TAG + "OnReachMaxDuration, recordTime: " + j + " ,maxDuration: " + j2);
        MainHandler.getInstance().post(new Runnable() { // from class: com.yy.audioengine.AudioRecordTool.3
            @Override // java.lang.Runnable
            public void run() {
                if (AudioRecordTool.this.mNotify != null) {
                    AudioRecordTool.this.mNotify.onReachMaxDuration();
                }
            }
        });
    }
}
