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
    private static j nRN = null;
    private final LruCache<String, VideoPlayInfo> nRM = new LruCache<String, VideoPlayInfo>(50) { // from class: com.kascend.chushou.d.j.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* renamed from: a */
        public int sizeOf(String str, VideoPlayInfo videoPlayInfo) {
            return 1;
        }
    };
    private final LruCache<String, VideoPlayInfo> adR = new LruCache<String, VideoPlayInfo>(100) { // from class: com.kascend.chushou.d.j.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* renamed from: a */
        public int sizeOf(String str, VideoPlayInfo videoPlayInfo) {
            return 1;
        }
    };

    public static j ecE() {
        if (nRN == null) {
            synchronized (j.class) {
                if (nRN == null) {
                    nRN = new j();
                }
            }
        }
        return nRN;
    }

    private j() {
    }

    public VideoPlayInfo N(String str, long j) {
        return a(this.nRM, str, j);
    }

    public void a(String str) {
        this.nRM.remove(str);
    }

    public void a(String str, List<PlayUrl> list) {
        a(this.nRM, str, list);
    }

    public void a(final String str, final String str2) {
        if (O(str, 600000L) == null) {
            com.kascend.chushou.player.c.a.edq().a(str, str2, new a.InterfaceC0884a() { // from class: com.kascend.chushou.d.j.3
                @Override // com.kascend.chushou.player.c.a.InterfaceC0884a
                public void a(ParserRet parserRet) {
                    if (parserRet.mRc == 0 && parserRet.mData != null) {
                        j.ecE().a(str + str2, (ArrayList) parserRet.mData);
                    }
                }
            });
        }
    }

    public VideoPlayInfo O(String str, long j) {
        return a(this.adR, str, j);
    }

    public void b(String str) {
        this.adR.remove(str);
    }

    public void s(String str, List<PlayUrl> list) {
        a(this.adR, str, list);
    }

    public void a(String str, int i) {
        VideoPlayInfo videoPlayInfo = this.adR.get(str);
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
