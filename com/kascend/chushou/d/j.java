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
    private static j phP = null;
    private final LruCache<String, VideoPlayInfo> phO = new LruCache<String, VideoPlayInfo>(50) { // from class: com.kascend.chushou.d.j.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* renamed from: a */
        public int sizeOf(String str, VideoPlayInfo videoPlayInfo) {
            return 1;
        }
    };
    private final LruCache<String, VideoPlayInfo> aej = new LruCache<String, VideoPlayInfo>(100) { // from class: com.kascend.chushou.d.j.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* renamed from: a */
        public int sizeOf(String str, VideoPlayInfo videoPlayInfo) {
            return 1;
        }
    };

    public static j eue() {
        if (phP == null) {
            synchronized (j.class) {
                if (phP == null) {
                    phP = new j();
                }
            }
        }
        return phP;
    }

    private j() {
    }

    public VideoPlayInfo Q(String str, long j) {
        return a(this.phO, str, j);
    }

    public void a(String str) {
        this.phO.remove(str);
    }

    public void a(String str, List<PlayUrl> list) {
        a(this.phO, str, list);
    }

    public void a(final String str, final String str2) {
        if (R(str, 600000L) == null) {
            com.kascend.chushou.player.c.a.euQ().a(str, str2, new a.InterfaceC0993a() { // from class: com.kascend.chushou.d.j.3
                @Override // com.kascend.chushou.player.c.a.InterfaceC0993a
                public void a(ParserRet parserRet) {
                    if (parserRet.mRc == 0 && parserRet.mData != null) {
                        j.eue().a(str + str2, (ArrayList) parserRet.mData);
                    }
                }
            });
        }
    }

    public VideoPlayInfo R(String str, long j) {
        return a(this.aej, str, j);
    }

    public void b(String str) {
        this.aej.remove(str);
    }

    public void s(String str, List<PlayUrl> list) {
        a(this.aej, str, list);
    }

    public void a(String str, int i) {
        VideoPlayInfo videoPlayInfo = this.aej.get(str);
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
