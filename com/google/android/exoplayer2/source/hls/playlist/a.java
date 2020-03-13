package com.google.android.exoplayer2.source.hls.playlist;

import com.google.android.exoplayer2.Format;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public final class a extends c {
    public final List<C0681a> audios;
    public final List<Format> mvU;
    public final Format mwF;
    public final List<C0681a> mwS;
    public final List<C0681a> mwT;

    /* renamed from: com.google.android.exoplayer2.source.hls.playlist.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0681a {
        public final Format lZJ;
        public final String url;

        public static C0681a PN(String str) {
            return new C0681a(str, Format.e("0", "application/x-mpegURL", null, null, -1, 0, null));
        }

        public C0681a(String str, Format format) {
            this.url = str;
            this.lZJ = format;
        }
    }

    public a(String str, List<String> list, List<C0681a> list2, List<C0681a> list3, List<C0681a> list4, Format format, List<Format> list5) {
        super(str, list);
        this.mwS = Collections.unmodifiableList(list2);
        this.audios = Collections.unmodifiableList(list3);
        this.mwT = Collections.unmodifiableList(list4);
        this.mwF = format;
        this.mvU = list5 != null ? Collections.unmodifiableList(list5) : null;
    }

    public static a PM(String str) {
        List singletonList = Collections.singletonList(C0681a.PN(str));
        List emptyList = Collections.emptyList();
        return new a(null, Collections.emptyList(), singletonList, emptyList, emptyList, null, null);
    }
}
