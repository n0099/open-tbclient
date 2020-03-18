package com.google.android.exoplayer2.source.hls.playlist;

import com.google.android.exoplayer2.Format;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public final class a extends c {
    public final List<C0682a> audios;
    public final List<Format> mxA;
    public final Format myl;
    public final List<C0682a> myy;
    public final List<C0682a> myz;

    /* renamed from: com.google.android.exoplayer2.source.hls.playlist.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0682a {
        public final Format mbs;
        public final String url;

        public static C0682a PM(String str) {
            return new C0682a(str, Format.e("0", "application/x-mpegURL", null, null, -1, 0, null));
        }

        public C0682a(String str, Format format) {
            this.url = str;
            this.mbs = format;
        }
    }

    public a(String str, List<String> list, List<C0682a> list2, List<C0682a> list3, List<C0682a> list4, Format format, List<Format> list5) {
        super(str, list);
        this.myy = Collections.unmodifiableList(list2);
        this.audios = Collections.unmodifiableList(list3);
        this.myz = Collections.unmodifiableList(list4);
        this.myl = format;
        this.mxA = list5 != null ? Collections.unmodifiableList(list5) : null;
    }

    public static a PL(String str) {
        List singletonList = Collections.singletonList(C0682a.PM(str));
        List emptyList = Collections.emptyList();
        return new a(null, Collections.emptyList(), singletonList, emptyList, emptyList, null, null);
    }
}
