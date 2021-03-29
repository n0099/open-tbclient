package com.xiaomi.push;

import com.baidu.tbadk.core.data.SmallTailInfo;
import java.util.Date;
/* loaded from: classes7.dex */
public class fk implements fo {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ fj f40507a;

    public fk(fj fjVar) {
        this.f40507a = fjVar;
    }

    @Override // com.xiaomi.push.fo
    public void a(fl flVar) {
        com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + this.f40507a.f385a.format(new Date()) + " Connection started (" + this.f40507a.f382a.hashCode() + SmallTailInfo.EMOTION_SUFFIX);
    }

    @Override // com.xiaomi.push.fo
    public void a(fl flVar, int i, Exception exc) {
        com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + this.f40507a.f385a.format(new Date()) + " Connection closed (" + this.f40507a.f382a.hashCode() + SmallTailInfo.EMOTION_SUFFIX);
    }

    @Override // com.xiaomi.push.fo
    public void a(fl flVar, Exception exc) {
        com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + this.f40507a.f385a.format(new Date()) + " Reconnection failed due to an exception (" + this.f40507a.f382a.hashCode() + SmallTailInfo.EMOTION_SUFFIX);
        exc.printStackTrace();
    }

    @Override // com.xiaomi.push.fo
    public void b(fl flVar) {
        com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + this.f40507a.f385a.format(new Date()) + " Connection reconnected (" + this.f40507a.f382a.hashCode() + SmallTailInfo.EMOTION_SUFFIX);
    }
}
