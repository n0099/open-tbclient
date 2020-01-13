package com.google.android.exoplayer2.source.hls.playlist;

import com.google.android.exoplayer2.Format;
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public final class a extends c {
    public final List<C0673a> audios;
    public final List<Format> muW;
    public final Format mvH;
    public final List<C0673a> mvU;
    public final List<C0673a> mvV;

    /* renamed from: com.google.android.exoplayer2.source.hls.playlist.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0673a {
        public final Format lYL;
        public final String url;

        public static C0673a Pz(String str) {
            return new C0673a(str, Format.c("0", "application/x-mpegURL", null, null, -1, 0, null));
        }

        public C0673a(String str, Format format) {
            this.url = str;
            this.lYL = format;
        }
    }

    public a(String str, List<String> list, List<C0673a> list2, List<C0673a> list3, List<C0673a> list4, Format format, List<Format> list5) {
        super(str, list);
        this.mvU = Collections.unmodifiableList(list2);
        this.audios = Collections.unmodifiableList(list3);
        this.mvV = Collections.unmodifiableList(list4);
        this.mvH = format;
        this.muW = list5 != null ? Collections.unmodifiableList(list5) : null;
    }

    public static a Py(String str) {
        List singletonList = Collections.singletonList(C0673a.Pz(str));
        List emptyList = Collections.emptyList();
        return new a(null, Collections.emptyList(), singletonList, emptyList, emptyList, null, null);
    }
}
