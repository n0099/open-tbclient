package com.yy.audioengine;
/* loaded from: classes4.dex */
public class AudioPlayBackAndMix implements IFileMixerNotify, IFilePlayerNotify {
    private static String TAG = "[AudioPlayBackAndMix]";
    private String mAacOutPath;
    private FilePlayer mAccompanyFilePlayer;
    private AudioFileMixerPoint mAccompanyPoint;
    private AudioFileMixer mAudioFileMixer;
    private IAudioPlayBackAndMixNotify mNotify;
    private FilePlayer mVoicePlayer;
    private AudioFileMixerPoint mVoicePoint;

    public void initWithOutputAACPath(String str) {
        YALog.info(TAG + "initWithOutputAACPath: " + str);
        this.mAacOutPath = str;
        this.mVoicePlayer = new FilePlayer();
        this.mAccompanyFilePlayer = new FilePlayer();
        this.mVoicePlayer.enableVolumeNotify(true);
        this.mAccompanyFilePlayer.enableVolumeNotify(true);
        this.mAudioFileMixer = new AudioFileMixer();
        this.mAudioFileMixer.registerNotify(this);
    }

    public void destroy() {
        YALog.info(TAG + "destroy....");
        if (this.mAccompanyFilePlayer != null) {
            this.mAccompanyFilePlayer.destroy();
            this.mAccompanyFilePlayer = null;
        }
        if (this.mVoicePlayer != null) {
            this.mVoicePlayer.destroy();
            this.mVoicePlayer = null;
        }
        if (this.mVoicePoint != null) {
            this.mVoicePoint.close();
            this.mVoicePoint = null;
        }
        if (this.mAccompanyPoint != null) {
            this.mAccompanyPoint.close();
            this.mVoicePoint = null;
        }
        if (this.mAudioFileMixer != null) {
            this.mAudioFileMixer.destroy();
            this.mAudioFileMixer = null;
        }
        this.mNotify = null;
    }

    public void setAudioPlayBackAndMixNotify(IAudioPlayBackAndMixNotify iAudioPlayBackAndMixNotify) {
        this.mNotify = iAudioPlayBackAndMixNotify;
    }

    public void startPlay() {
        YALog.info(TAG + "startPlay....");
        if (this.mVoicePlayer != null) {
            this.mVoicePlayer.play();
        }
        if (this.mAccompanyFilePlayer != null) {
            this.mAccompanyFilePlayer.play();
        }
    }

    public void pausePlay() {
        YALog.info(TAG + "pausePlay....");
        if (this.mVoicePlayer != null) {
            this.mVoicePlayer.pause();
        }
        if (this.mAccompanyFilePlayer != null) {
            this.mAccompanyFilePlayer.pause();
        }
    }

    public void resumePlay() {
        YALog.info(TAG + "resumePlay....");
        if (this.mVoicePlayer != null) {
            this.mVoicePlayer.resume();
        }
        if (this.mAccompanyFilePlayer != null) {
            this.mAccompanyFilePlayer.resume();
        }
    }

    public void stopPlay() {
        YALog.info(TAG + "stopPlay....");
        if (this.mVoicePlayer != null) {
            this.mVoicePlayer.stop();
        }
        if (this.mAccompanyFilePlayer != null) {
            this.mAccompanyFilePlayer.stop();
        }
    }

    public void startMixVoice() {
        YALog.info(TAG + "startMixVoice....");
        if (this.mAudioFileMixer != null) {
            this.mAudioFileMixer.start(this.mAacOutPath);
        }
    }

    public void stopMixVoice() {
        YALog.info(TAG + "stopMixVoice....");
        if (this.mAudioFileMixer != null) {
            this.mAudioFileMixer.stop();
        }
    }

    public void setVoiceFilePath(String str) {
        YALog.info(TAG + "setVoiceFilePath....: " + str);
        this.mVoicePlayer.open(str);
        this.mVoicePlayer.registerNotify(this);
        if (this.mVoicePoint != null) {
            this.mVoicePoint.close();
            this.mVoicePoint = null;
        }
        AudioFileMixerPoint createMixerPoint = this.mAudioFileMixer.createMixerPoint();
        if (createMixerPoint.open(str)) {
            this.mVoicePoint = createMixerPoint;
        } else {
            createMixerPoint.close();
        }
    }

    public void setAccompanyFilePath(String str) {
        YALog.info(TAG + "setAccompanyFilePath....: " + str);
        this.mAccompanyFilePlayer.open(str);
        if (this.mAccompanyPoint != null) {
            this.mAccompanyPoint.close();
            this.mAccompanyPoint = null;
        }
        AudioFileMixerPoint createMixerPoint = this.mAudioFileMixer.createMixerPoint();
        if (createMixerPoint.open(str)) {
            this.mAccompanyPoint = createMixerPoint;
        } else {
            createMixerPoint.close();
        }
    }

    @Override // com.yy.audioengine.IFileMixerNotify
    public void onFileMixerState(long j, long j2) {
        if (this.mNotify != null) {
            this.mNotify.fileMixerProgress(j, j2);
        }
    }

    @Override // com.yy.audioengine.IFileMixerNotify
    public void onFinishMixer() {
        YALog.info(TAG + "OnFinishMixer....");
        MainHandler.getInstance().post(new Runnable() { // from class: com.yy.audioengine.AudioPlayBackAndMix.1
            @Override // java.lang.Runnable
            public void run() {
                if (AudioPlayBackAndMix.this.mNotify != null) {
                    AudioPlayBackAndMix.this.mNotify.finishMixer();
                }
            }
        });
    }

    @Override // com.yy.audioengine.IFilePlayerNotify
    public void onPlayerEnd() {
        YALog.info(TAG + "OnPlayerEnd....");
        MainHandler.getInstance().post(new Runnable() { // from class: com.yy.audioengine.AudioPlayBackAndMix.2
            @Override // java.lang.Runnable
            public void run() {
                if (AudioPlayBackAndMix.this.mNotify != null) {
                    AudioPlayBackAndMix.this.mNotify.playBackEnd();
                }
            }
        });
    }

    @Override // com.yy.audioengine.IFilePlayerNotify
    public void onPlayerVolume(int i, long j, long j2) {
        if (this.mNotify != null) {
            this.mNotify.playBackProgress(i, j, j2);
        }
    }
}
