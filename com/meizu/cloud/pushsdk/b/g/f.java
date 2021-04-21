package com.meizu.cloud.pushsdk.b.g;

import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.IOException;
/* loaded from: classes6.dex */
public abstract class f implements l {

    /* renamed from: a  reason: collision with root package name */
    public final l f37975a;

    public f(l lVar) {
        if (lVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f37975a = lVar;
    }

    @Override // com.meizu.cloud.pushsdk.b.g.l
    public void a(b bVar, long j) throws IOException {
        this.f37975a.a(bVar, j);
    }

    @Override // com.meizu.cloud.pushsdk.b.g.l, java.io.Closeable, java.lang.AutoCloseable, com.meizu.cloud.pushsdk.b.g.m
    public void close() throws IOException {
        this.f37975a.close();
    }

    @Override // com.meizu.cloud.pushsdk.b.g.l, java.io.Flushable
    public void flush() throws IOException {
        this.f37975a.flush();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f37975a.toString() + SmallTailInfo.EMOTION_SUFFIX;
    }
}
