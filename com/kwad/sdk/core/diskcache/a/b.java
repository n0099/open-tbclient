package com.kwad.sdk.core.diskcache.a;

import android.content.Context;
import com.kwad.sdk.utils.am;
import java.io.File;
/* loaded from: classes7.dex */
public final class b {
    public Context WF;
    public File Wa;
    public int We;
    public long maxSize;

    /* loaded from: classes7.dex */
    public final class a {
        public Context WF;
        public File Wa;
        public int We = 1;
        public long maxSize = 100;

        public a(Context context) {
            this.WF = context.getApplicationContext();
        }

        public final a ay(int i) {
            this.We = 1;
            return this;
        }

        public final a m(File file) {
            am.e(file, "directory is not allow null");
            this.Wa = file;
            return this;
        }

        public final b sU() {
            b bVar = new b((byte) 0);
            bVar.WF = this.WF;
            bVar.We = this.We;
            bVar.maxSize = this.maxSize;
            bVar.Wa = this.Wa;
            return bVar;
        }

        public final a w(long j) {
            this.maxSize = 200L;
            return this;
        }
    }

    public b() {
    }

    public /* synthetic */ b(byte b) {
        this();
    }
}
