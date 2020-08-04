package com.kascend.chushou.d;

import android.util.LruCache;
import com.kascend.chushou.constants.ParserRet;
import com.kascend.chushou.constants.PlayUrl;
import com.kascend.chushou.constants.VideoPlayInfo;
import com.kascend.chushou.player.c.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class j {
    private static j nnJ = null;
    private final LruCache<String, VideoPlayInfo> nnI = new LruCache<String, VideoPlayInfo>(50) { // from class: com.kascend.chushou.d.j.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* renamed from: a */
        public int sizeOf(String str, VideoPlayInfo videoPlayInfo) {
            return 1;
        }
    };
    private final LruCache<String, VideoPlayInfo> abP = new LruCache<String, VideoPlayInfo>(100) { // from class: com.kascend.chushou.d.j.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* renamed from: a */
        public int sizeOf(String str, VideoPlayInfo videoPlayInfo) {
            return 1;
        }
    };

    public static j dMv() {
        if (nnJ == null) {
            synchronized (j.class) {
                if (nnJ == null) {
                    nnJ = new j();
                }
            }
        }
        return nnJ;
    }

    private j() {
    }

    public VideoPlayInfo K(String str, long j) {
        return a(this.nnI, str, j);
    }

    public void a(String str) {
        this.nnI.remove(str);
    }

    public void a(String str, List<PlayUrl> list) {
        a(this.nnI, str, list);
    }

    public void a(final String str, final String str2) {
        if (L(str, 600000L) == null) {
            com.kascend.chushou.player.c.a.dNj().a(str, str2, new a.InterfaceC0829a() { // from class: com.kascend.chushou.d.j.3
                @Override // com.kascend.chushou.player.c.a.InterfaceC0829a
                public void a(ParserRet parserRet) {
                    if (parserRet.mRc == 0 && parserRet.mData != null) {
                        j.dMv().a(str + str2, (ArrayList) parserRet.mData);
                    }
                }
            });
        }
    }

    public VideoPlayInfo L(String str, long j) {
        return a(this.abP, str, j);
    }

    public void b(String str) {
        this.abP.remove(str);
    }

    public void t(String str, List<PlayUrl> list) {
        a(this.abP, str, list);
    }

    public void a(String str, int i) {
        VideoPlayInfo videoPlayInfo = this.abP.get(str);
        if (videoPlayInfo != null) {
            videoPlayInfo.mPos = i;
        }
    }

    private VideoPlayInfo a(LruCache<String, VideoPlayInfo> lruCache, String str, long j) {
        VideoPlayInfo videoPlayInfo = lruCache.get(str);
        if (videoPlayInfo == null) {
            return null;
        }
        if (tv.chushou.zues.utils.h.isEmpty(videoPlayInfo.mPlayUrls) || System.currentTimeMillis() - videoPlayInfo.mTime <= 0 || System.currentTimeMillis() - videoPlayInfo.mTime >= videoPlayInfo.mEffectiveTime - j) {
            return null;
        }
        return videoPlayInfo;
    }

    private void a(LruCache<String, VideoPlayInfo> lruCache, String str, List<PlayUrl> list) {
        if (!tv.chushou.zues.utils.h.isEmpty(str) && !tv.chushou.zues.utils.h.isEmpty(list)) {
            VideoPlayInfo videoPlayInfo = lruCache.get(str);
            VideoPlayInfo videoPlayInfo2 = videoPlayInfo == null ? new VideoPlayInfo() : videoPlayInfo;
            videoPlayInfo2.mPlayUrls = new ArrayList(list);
            videoPlayInfo2.mTime = System.currentTimeMillis();
            for (PlayUrl playUrl : list) {
                if (videoPlayInfo2.mEffectiveTime == 0) {
                    videoPlayInfo2.mEffectiveTime = playUrl.mEffectiveTime;
                } else if (playUrl.mEffectiveTime < videoPlayInfo2.mEffectiveTime) {
                    videoPlayInfo2.mEffectiveTime = playUrl.mEffectiveTime;
                }
            }
            lruCache.put(str, videoPlayInfo2);
        }
    }
}
