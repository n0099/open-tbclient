package com.google.android.exoplayer2.source.hls.playlist;

import com.google.android.exoplayer2.Format;
import java.util.Collections;
import java.util.List;
/* loaded from: classes4.dex */
public final class a extends c {
    public final List<C0667a> audios;
    public final Format mrS;
    public final List<Format> mrh;
    public final List<C0667a> msf;
    public final List<C0667a> msh;

    /* renamed from: com.google.android.exoplayer2.source.hls.playlist.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C0667a {
        public final Format lUU;
        public final String url;

        public static C0667a Po(String str) {
            return new C0667a(str, Format.c("0", "application/x-mpegURL", null, null, -1, 0, null));
        }

        public C0667a(String str, Format format) {
            this.url = str;
            this.lUU = format;
        }
    }

    public a(String str, List<String> list, List<C0667a> list2, List<C0667a> list3, List<C0667a> list4, Format format, List<Format> list5) {
        super(str, list);
        this.msf = Collections.unmodifiableList(list2);
        this.audios = Collections.unmodifiableList(list3);
        this.msh = Collections.unmodifiableList(list4);
        this.mrS = format;
        this.mrh = list5 != null ? Collections.unmodifiableList(list5) : null;
    }

    public static a Pn(String str) {
        List singletonList = Collections.singletonList(C0667a.Po(str));
        List emptyList = Collections.emptyList();
        return new a(null, Collections.emptyList(), singletonList, emptyList, emptyList, null, null);
    }
}
