package com.yy.mediaframework;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.yy.mediaframework.filters.AbstractYYMediaFilter;
import com.yy.mediaframework.filters.VideoLiveFilterContext;
import com.yy.mediaframework.gles.EglFactory;
import com.yy.mediaframework.gles.IEglCore;
import com.yy.mediaframework.gles.IEglSurfaceBase;
import com.yy.mediaframework.stat.UploadStatManager;
import com.yy.mediaframework.stat.YMFLiveUsrBehaviorStat;
import com.yy.mediaframework.utils.YMFLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
@SuppressLint({"NewApi"})
/* loaded from: classes6.dex */
public class GlManager implements Runnable {
    private static final String TAG = "GlManager";
    private IEglCore mEglCore;
    private IEglSurfaceBase mEnvSurface;
    private boolean mIsInitException;
    public Thread mLooperThread;
    private Object mSharedContext;
    private int mType;
    private VideoLiveFilterContext mVideoLiveFilterContext;
    public GlHandler mGlHandler = null;
    public YMFGlManagerTest mGlManagerTest = null;
    private AtomicBoolean mStartLock = new AtomicBoolean(false);
    private int mDefaultWidth = 10;
    private int mDefaultHeight = 10;
    private ArrayList<AbstractYYMediaFilter> mFilterArray = new ArrayList<>();
    private AtomicBoolean mIsQuit = new AtomicBoolean(false);

    public GlManager(int i, Object obj) {
        this.mSharedContext = null;
        this.mType = i;
        this.mSharedContext = obj;
        long currentTimeMillis = System.currentTimeMillis();
        this.mLooperThread = new Thread(this, "YY_yyvideolib_GlManager_Thread");
        this.mLooperThread.start();
        synchronized (this.mStartLock) {
            if (!this.mStartLock.get()) {
                try {
                    this.mStartLock.wait();
                } catch (InterruptedException e) {
                    YMFLog.error(this, "[Procedur]", "GlManager construct exeception:" + e.getMessage());
                }
            }
        }
        YMFLog.info(this, "[Procedur]", "GlManager constructor cost:" + (System.currentTimeMillis() - currentTimeMillis));
    }

    public void setVideoLiveFilterContext(VideoLiveFilterContext videoLiveFilterContext) {
        this.mVideoLiveFilterContext = videoLiveFilterContext;
    }

    public long getThreadId() {
        return this.mLooperThread.getId();
    }

    public Handler getHandler() {
        return this.mGlHandler;
    }

    public IEglCore getEglCore() {
        return this.mEglCore;
    }

    public void resetContext() {
        this.mEglCore.makeCurrent(this.mEnvSurface);
    }

    private void InitEGL() {
        this.mIsInitException = true;
        if (((Build.MODEL.equalsIgnoreCase("M355") || Build.MODEL.equalsIgnoreCase("M351") || Build.MODEL.equalsIgnoreCase("GT-I9500")) && Build.VERSION.SDK_INT == 19) || Build.MODEL.equalsIgnoreCase("vivo X3t") || Build.MODEL.equalsIgnoreCase("2013023") || Build.MODEL.equalsIgnoreCase("Lenovo K900")) {
            this.mEglCore = EglFactory.createEGL(this.mSharedContext, 0);
        } else {
            this.mEglCore = EglFactory.createEGL(this.mSharedContext, 1);
        }
        this.mEnvSurface = this.mEglCore.createSurfaceBase();
        this.mEnvSurface.createOffscreenSurface(this.mDefaultWidth, this.mDefaultHeight);
        this.mEglCore.makeCurrent(this.mEnvSurface);
        YMFLog.info(this, "[Procedur]", "Texture created thread id:" + Thread.currentThread().getId());
        this.mIsInitException = false;
    }

    private void deInitEGL() {
        if (this.mEnvSurface != null) {
            this.mEglCore.makeNothingCurrent();
            this.mEnvSurface.releaseEglSurface();
            this.mEnvSurface = null;
        }
        if (this.mEglCore != null) {
            this.mEglCore.release();
            this.mEglCore = null;
        }
    }

    public void quit() {
        this.mIsQuit.set(true);
        YMFLog.info(this, "[Procedur]", "quit GlManager thread, quitSafely...");
        this.mGlManagerTest.quit();
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            if (Build.VERSION.SDK_INT >= 18) {
                myLooper.quitSafely();
            } else {
                myLooper.quit();
            }
        }
    }

    public void registerFilter(AbstractYYMediaFilter abstractYYMediaFilter) {
        YMFLog.info(this, "[Procedur]", "registerFilter");
        synchronized (this.mFilterArray) {
            this.mFilterArray.add(abstractYYMediaFilter);
        }
    }

    private void releaseFilters() {
        YMFLog.info(this, "[Procedur]", "releaseFilters");
        synchronized (this.mFilterArray) {
            Iterator<AbstractYYMediaFilter> it = this.mFilterArray.iterator();
            while (it.hasNext()) {
                AbstractYYMediaFilter next = it.next();
                if (next != null) {
                    next.deInit();
                }
            }
            this.mFilterArray.clear();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        YMFLog.info(this, "[Procedur]", "glManager thread begin!!!!!");
        YMFLiveUsrBehaviorStat.getInstance().notifyVideoGlManagerState(this.mType, true);
        try {
            Looper.prepare();
            this.mGlHandler = new GlHandler(this);
            this.mGlManagerTest = new YMFGlManagerTest(this);
            synchronized (this.mStartLock) {
                this.mStartLock.set(true);
                this.mStartLock.notifyAll();
            }
            InitEGL();
            Looper.loop();
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                if (this.mIsInitException) {
                    UploadStatManager.getInstance().reportException("2", "101", th.getMessage());
                } else {
                    UploadStatManager.getInstance().reportException("2", "102", th.getMessage());
                }
                YMFLog.error(this, "[Procedur]", "glManager run exception:" + th.getMessage());
                YMFLog.info(this, "[Procedur]", "glManager releaseFilters");
                if (this != null) {
                    releaseFilters();
                    try {
                        deInitEGL();
                    } catch (Throwable th2) {
                        UploadStatManager.getInstance().reportException("2", "103", th2.getMessage());
                        YMFLog.error(this, "[Procedur]", "deInitEGL exception:" + th2.getMessage());
                    }
                }
            } finally {
                YMFLog.info(this, "[Procedur]", "glManager releaseFilters");
                if (this != null) {
                    releaseFilters();
                    try {
                        deInitEGL();
                    } catch (Throwable th3) {
                        UploadStatManager.getInstance().reportException("2", "103", th3.getMessage());
                        YMFLog.error(this, "[Procedur]", "deInitEGL exception:" + th3.getMessage());
                    }
                }
            }
        }
        YMFLiveUsrBehaviorStat.getInstance().notifyVideoGlManagerState(this.mType, false);
        YMFLog.info(this, "[Procedur]", "glManager thread exit!!!!!");
    }

    public boolean checkSameThread() {
        return Thread.currentThread().getId() == getThreadId();
    }

    public boolean post(Runnable runnable) {
        if (this.mIsQuit.get()) {
            return false;
        }
        try {
            if (this.mGlHandler.getLooper() != null) {
                return this.mGlHandler.post(runnable);
            }
            return false;
        } catch (Throwable th) {
            YMFLog.error(this, "[Procedur]", "GlManager PostRunnable exeception:" + th.toString());
            return false;
        }
    }

    public boolean postDelayed(Runnable runnable, int i) {
        try {
            if (this.mGlHandler.getLooper() == null) {
                return false;
            }
            return this.mGlHandler.postDelayed(runnable, i);
        } catch (Throwable th) {
            YMFLog.error(this, "[Procedur]", "GlManager PostRunnable exeception:" + th.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class GlHandler extends Handler {
        private WeakReference<GlManager> mWeakGLManager;

        public GlHandler(GlManager glManager) {
            this.mWeakGLManager = new WeakReference<>(glManager);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            Object obj = message.obj;
            if (this.mWeakGLManager.get() == null) {
                YMFLog.warn(this, "[Procedur]", "handleMessage: GlManager is null");
            }
        }
    }
}
