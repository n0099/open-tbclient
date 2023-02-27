package com.xiaomi.push;

import com.baidu.tbadk.core.data.SmallTailInfo;
import java.util.Date;
/* loaded from: classes8.dex */
public class fu implements fy {
    public final /* synthetic */ ft a;

    public fu(ft ftVar) {
        this.a = ftVar;
    }

    @Override // com.xiaomi.push.fy
    public void a(fv fvVar) {
        com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + this.a.f403a.format(new Date()) + " Connection started (" + this.a.f400a.hashCode() + SmallTailInfo.EMOTION_SUFFIX);
    }

    @Override // com.xiaomi.push.fy
    public void a(fv fvVar, int i, Exception exc) {
        com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + this.a.f403a.format(new Date()) + " Connection closed (" + this.a.f400a.hashCode() + SmallTailInfo.EMOTION_SUFFIX);
    }

    @Override // com.xiaomi.push.fy
    public void a(fv fvVar, Exception exc) {
        com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + this.a.f403a.format(new Date()) + " Reconnection failed due to an exception (" + this.a.f400a.hashCode() + SmallTailInfo.EMOTION_SUFFIX);
        exc.printStackTrace();
    }

    @Override // com.xiaomi.push.fy
    public void b(fv fvVar) {
        com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + this.a.f403a.format(new Date()) + " Connection reconnected (" + this.a.f400a.hashCode() + SmallTailInfo.EMOTION_SUFFIX);
    }
}
