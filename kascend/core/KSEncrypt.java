package kascend.core;

import android.content.Context;
/* loaded from: classes6.dex */
public class KSEncrypt {
    private Context mContext;
    private boolean r;
    private long id = -1;
    private boolean mInited = false;
    private boolean sourced = false;
    private a mCallback = null;

    private native String device(Context context, String[] strArr);

    private native String encrypt(long j, String[] strArr);

    private native String encrypt2(long j, String str);

    private native long getUid();

    private native void init(Context context, boolean z);

    private native void source(long j, String str);

    public native int getVersion();

    public a getCallback() {
        return this.mCallback;
    }

    public void setCallback(a aVar) {
        this.mCallback = aVar;
    }

    public KSEncrypt(Context context, boolean z) {
        this.mContext = null;
        this.mContext = context;
        this.r = z;
    }

    public void init() {
        init(this.mContext, this.r);
        this.mInited = true;
    }

    public String device(String[] strArr) {
        return device(this.mContext, strArr);
    }

    public void source(String str) {
        if (this.mInited) {
            source(this.id, str);
            this.sourced = true;
        }
    }

    public String encrypt(String[] strArr) {
        return (this.mInited && this.sourced) ? encrypt(this.id, strArr) : "";
    }

    public String encrypt2(String str) {
        return (this.mInited && this.sourced) ? encrypt2(this.id, str) : "";
    }

    public long getSoUid() {
        if (this.mInited) {
            return getUid();
        }
        return -1L;
    }
}
