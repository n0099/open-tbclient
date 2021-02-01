package com.thunder.livesdk.video;

import android.os.Build;
import com.thunder.livesdk.helper.ThunderNative;
import com.thunder.livesdk.log.ThunderLog;
import com.yy.videoplayer.decoder.H264DecRender;
import com.yy.videoplayer.decoder.H265DecRender;
import com.yy.videoplayer.decoder.HardDecodeDirectRenderConfig;
import com.yy.videoplayer.decoder.YYVideoLibMgr;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes4.dex */
public class ThunderVideoConfig {
    private HardDecodeDirectRenderConfig mHardDirectRender = new HardDecodeDirectRenderConfig();
    private static Support h264HwDecoderSupport = Support.SUPPORTED;
    private static Support h265HwDecoderSupport = Support.SUPPORTED;
    private static boolean bRooted = false;
    private static boolean bWindowSurfaceSupported = false;
    private static final Object testWindowSurfaceLocker = new Object();

    /* loaded from: classes4.dex */
    private enum Support {
        SUPPORTED,
        UNSUPPORTED,
        UNCERTAIN
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void AsyncLoad() {
        new Thread(new LoadThread(), "YY_LoadVideoConfig_Thread").start();
    }

    /* loaded from: classes4.dex */
    private class LoadThread implements Runnable {
        private LoadThread() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                boolean unused = ThunderVideoConfig.bRooted = ThunderVideoConfig.this.testRooted();
                try {
                    Thread.sleep(500L);
                } catch (Exception e) {
                    ThunderLog.error(ThunderLog.kLogTagVideo, "Exception:" + e.toString());
                }
                Integer valueOf = Integer.valueOf(ThunderNative.getHardDecodeDirectRenderConfig());
                YYVideoLibMgr.instance().setConfig(0, valueOf);
                ThunderLog.release(ThunderLog.kLogTagVideo, "load finish - build version:" + Build.VERSION.SDK_INT + ", h264HwDecoderSupport:" + ThunderVideoConfig.h264HwDecoderSupport.name() + ", h265HwDecoderSupport:" + ThunderVideoConfig.h265HwDecoderSupport.name() + ", isRooted:" + ThunderVideoConfig.bRooted + ", isWindowSurfaceSupported:" + ThunderVideoConfig.bWindowSurfaceSupported + ", getHardDecodeDirectRenderConfig:" + valueOf);
            } catch (Exception e2) {
                ThunderLog.error(ThunderLog.kLogTagVideo, "load error:" + e2.getMessage());
            }
        }
    }

    /* loaded from: classes4.dex */
    private static class TestWindowSurfaceTask implements Runnable {
        private AtomicBoolean mResult;

        TestWindowSurfaceTask(AtomicBoolean atomicBoolean) {
            this.mResult = null;
            this.mResult = atomicBoolean;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mResult == null) {
            }
        }
    }

    private static boolean testWindowSurfaceCreation() {
        boolean z = false;
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        Thread thread = new Thread(new TestWindowSurfaceTask(atomicBoolean), "YY_TestWindowSurface_Thread");
        synchronized (testWindowSurfaceLocker) {
            try {
                thread.start();
                testWindowSurfaceLocker.wait(500L);
                z = atomicBoolean.get();
            } catch (Exception e) {
            }
        }
        if (ThunderLog.isInfoValid()) {
            ThunderLog.info(ThunderLog.kLogTagVideo, "testWindowSurfaceCreation ret:" + z);
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0027, code lost:
        if (testFileExecutable("/system/xbin/su") != false) goto L7;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean testRooted() {
        boolean z = false;
        if (!new File("/system/bin/su").exists() || !testFileExecutable("/system/bin/su")) {
            if (new File("/system/xbin/su").exists()) {
            }
            if (ThunderLog.isInfoValid()) {
                ThunderLog.info(ThunderLog.kLogTagVideo, "testRooted: " + z);
            }
            return z;
        }
        z = true;
        if (ThunderLog.isInfoValid()) {
        }
        return z;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [194=4, 195=4] */
    private boolean testFileExecutable(String str) {
        Process process = null;
        try {
            try {
                process = Runtime.getRuntime().exec("ls -l " + str);
                String readLine = new BufferedReader(new InputStreamReader(process.getInputStream())).readLine();
                if (ThunderLog.isInfoValid()) {
                    ThunderLog.info(ThunderLog.kLogTagVideo, "testFileExecutable " + readLine);
                }
                if (readLine != null && readLine.length() >= 4) {
                    char charAt = readLine.charAt(3);
                    if (charAt == 's' || charAt == 'x') {
                    }
                }
                if (process != null) {
                    process.destroy();
                }
            } catch (IOException e) {
                if (ThunderLog.isInfoValid()) {
                    ThunderLog.info(ThunderLog.kLogTagVideo, "testFileExecutable failed:" + e.getMessage());
                }
                if (process != null) {
                    process.destroy();
                }
            }
            return false;
        } finally {
            if (process != null) {
                process.destroy();
            }
        }
    }

    public static boolean isRooted() {
        return bRooted;
    }

    public static boolean isWindowSurfaceSupport() {
        return bWindowSurfaceSupported;
    }

    public static boolean isHw264DecodeEnabled() {
        return h264HwDecoderSupport != Support.UNSUPPORTED && H264DecRender.IsAvailable();
    }

    public static boolean isHw265DecodeEnabled() {
        return h265HwDecoderSupport != Support.UNSUPPORTED && H265DecRender.IsAvailable();
    }
}
