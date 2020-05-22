package com.kascend.chushou.d;

import android.util.LruCache;
import com.baidu.tieba.keepLive.jobScheduler.KeepJobService;
import com.kascend.chushou.constants.ParserRet;
import com.kascend.chushou.constants.PlayUrl;
import com.kascend.chushou.constants.VideoPlayInfo;
import com.kascend.chushou.player.c.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class j {
    private static j mHJ = null;
    private final LruCache<String, VideoPlayInfo> mHI = new LruCache<String, VideoPlayInfo>(50) { // from class: com.kascend.chushou.d.j.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* renamed from: a */
        public int sizeOf(String str, VideoPlayInfo videoPlayInfo) {
            return 1;
        }
    };
    private final LruCache<String, VideoPlayInfo> abp = new LruCache<String, VideoPlayInfo>(100) { // from class: com.kascend.chushou.d.j.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* renamed from: a */
        public int sizeOf(String str, VideoPlayInfo videoPlayInfo) {
            return 1;
        }
    };

    public static j dEf() {
        if (mHJ == null) {
            synchronized (j.class) {
                if (mHJ == null) {
                    mHJ = new j();
                }
            }
        }
        return mHJ;
    }

    private j() {
    }

    public VideoPlayInfo L(String str, long j) {
        return a(this.mHI, str, j);
    }

    public void a(String str) {
        this.mHI.remove(str);
    }

    public void a(String str, List<PlayUrl> list) {
        a(this.mHI, str, list);
    }

    public void a(final String str, final String str2) {
        if (M(str, KeepJobService.JOB_CHECK_PERIODIC) == null) {
            com.kascend.chushou.player.c.a.dET().a(str, str2, new a.InterfaceC0799a() { // from class: com.kascend.chushou.d.j.3
                @Override // com.kascend.chushou.player.c.a.InterfaceC0799a
                public void a(ParserRet parserRet) {
                    if (parserRet.mRc == 0 && parserRet.mData != null) {
                        j.dEf().a(str + str2, (ArrayList) parserRet.mData);
                    }
                }
            });
        }
    }

    public VideoPlayInfo M(String str, long j) {
        return a(this.abp, str, j);
    }

    public void b(String str) {
        this.abp.remove(str);
    }

    public void t(String str, List<PlayUrl> list) {
        a(this.abp, str, list);
    }

    public void a(String str, int i) {
        VideoPlayInfo videoPlayInfo = this.abp.get(str);
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
