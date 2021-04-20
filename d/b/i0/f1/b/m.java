package d.b.i0.f1.b;

import com.squareup.wire.Wire;
import java.io.IOException;
import tbclient.ReplyMe.ReplyMeResIdl;
/* loaded from: classes4.dex */
public class m extends k implements d.b.h0.g0.b.b, d.b.h0.g0.b.h {
    @Override // d.b.h0.g0.b.c
    public String getCacheKey() {
        return "replyme_cache";
    }

    @Override // d.b.h0.g0.b.b
    public boolean initByByteArray(byte[] bArr) {
        try {
            initByProtobuf((ReplyMeResIdl) new Wire(new Class[0]).parseFrom(bArr, ReplyMeResIdl.class));
            return true;
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // d.b.h0.g0.b.b
    public byte[] toCacheByteArray() {
        return null;
    }
}
