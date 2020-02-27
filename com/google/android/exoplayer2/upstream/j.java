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
    private final q<? super e> mFH;
    private final e mGj;
    private e mGk;
    private e mGl;
    private e mGm;
    private e mGn;
    private e mGo;
    private e mdU;

    public j(Context context, q<? super e> qVar, e eVar) {
        this.context = context.getApplicationContext();
        this.mFH = qVar;
        this.mGj = (e) com.google.android.exoplayer2.util.a.checkNotNull(eVar);
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public long a(g gVar) throws IOException {
        com.google.android.exoplayer2.util.a.checkState(this.mdU == null);
        String scheme = gVar.uri.getScheme();
        if (v.isLocalFileUri(gVar.uri)) {
            if (gVar.uri.getPath().startsWith("/android_asset/")) {
                this.mdU = dyY();
            } else {
                this.mdU = dyX();
            }
        } else if ("asset".equals(scheme)) {
            this.mdU = dyY();
        } else if ("content".equals(scheme)) {
            this.mdU = dyZ();
        } else if ("rtmp".equals(scheme)) {
            this.mdU = dza();
        } else if ("data".equals(scheme)) {
            this.mdU = dzb();
        } else {
            this.mdU = this.mGj;
        }
        return this.mdU.a(gVar);
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public int read(byte[] bArr, int i, int i2) throws IOException {
        return this.mdU.read(bArr, i, i2);
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public Uri getUri() {
        if (this.mdU == null) {
            return null;
        }
        return this.mdU.getUri();
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public void close() throws IOException {
        if (this.mdU != null) {
            try {
                this.mdU.close();
            } finally {
                this.mdU = null;
            }
        }
    }

    private e dyX() {
        if (this.mGk == null) {
            this.mGk = new FileDataSource(this.mFH);
        }
        return this.mGk;
    }

    private e dyY() {
        if (this.mGl == null) {
            this.mGl = new AssetDataSource(this.context, this.mFH);
        }
        return this.mGl;
    }

    private e dyZ() {
        if (this.mGm == null) {
            this.mGm = new ContentDataSource(this.context, this.mFH);
        }
        return this.mGm;
    }

    private e dza() {
        if (this.mGn == null) {
            try {
                this.mGn = (e) Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
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
            if (this.mGn == null) {
                this.mGn = this.mGj;
            }
        }
        return this.mGn;
    }

    private e dzb() {
        if (this.mGo == null) {
            this.mGo = new d();
        }
        return this.mGo;
    }
}
