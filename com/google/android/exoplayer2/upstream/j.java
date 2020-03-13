package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.google.android.exoplayer2.util.v;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes6.dex */
public final class j implements e {
    private final Context context;
    private final q<? super e> mFU;
    private e mGA;
    private e mGB;
    private final e mGw;
    private e mGx;
    private e mGy;
    private e mGz;
    private e meh;

    public j(Context context, q<? super e> qVar, e eVar) {
        this.context = context.getApplicationContext();
        this.mFU = qVar;
        this.mGw = (e) com.google.android.exoplayer2.util.a.checkNotNull(eVar);
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public long a(g gVar) throws IOException {
        com.google.android.exoplayer2.util.a.checkState(this.meh == null);
        String scheme = gVar.uri.getScheme();
        if (v.isLocalFileUri(gVar.uri)) {
            if (gVar.uri.getPath().startsWith("/android_asset/")) {
                this.meh = dzb();
            } else {
                this.meh = dza();
            }
        } else if ("asset".equals(scheme)) {
            this.meh = dzb();
        } else if ("content".equals(scheme)) {
            this.meh = dzc();
        } else if ("rtmp".equals(scheme)) {
            this.meh = dzd();
        } else if ("data".equals(scheme)) {
            this.meh = dze();
        } else {
            this.meh = this.mGw;
        }
        return this.meh.a(gVar);
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public int read(byte[] bArr, int i, int i2) throws IOException {
        return this.meh.read(bArr, i, i2);
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public Uri getUri() {
        if (this.meh == null) {
            return null;
        }
        return this.meh.getUri();
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public void close() throws IOException {
        if (this.meh != null) {
            try {
                this.meh.close();
            } finally {
                this.meh = null;
            }
        }
    }

    private e dza() {
        if (this.mGx == null) {
            this.mGx = new FileDataSource(this.mFU);
        }
        return this.mGx;
    }

    private e dzb() {
        if (this.mGy == null) {
            this.mGy = new AssetDataSource(this.context, this.mFU);
        }
        return this.mGy;
    }

    private e dzc() {
        if (this.mGz == null) {
            this.mGz = new ContentDataSource(this.context, this.mFU);
        }
        return this.mGz;
    }

    private e dzd() {
        if (this.mGA == null) {
            try {
                this.mGA = (e) Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (ClassNotFoundException e) {
                Log.w("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
            } catch (IllegalAccessException e2) {
                Log.e("DefaultDataSource", "Error instantiating RtmpDataSource", e2);
            } catch (InstantiationException e3) {
                Log.e("DefaultDataSource", "Error instantiating RtmpDataSource", e3);
            } catch (NoSuchMethodException e4) {
                Log.e("DefaultDataSource", "Error instantiating RtmpDataSource", e4);
            } catch (InvocationTargetException e5) {
                Log.e("DefaultDataSource", "Error instantiating RtmpDataSource", e5);
            }
            if (this.mGA == null) {
                this.mGA = this.mGw;
            }
        }
        return this.mGA;
    }

    private e dze() {
        if (this.mGB == null) {
            this.mGB = new d();
        }
        return this.mGB;
    }
}
