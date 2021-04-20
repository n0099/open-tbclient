package d.b.i0.a1.h.a;

import com.squareup.wire.Message;
import com.squareup.wire.Wire;
import d.b.h0.g0.b.b;
import d.b.h0.g0.b.h;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import tbclient.Error;
import tbclient.ExcFrsPage.DataRes;
import tbclient.ExcFrsPage.ExcFrsPageResIdl;
import tbclient.ExcFrsPage.ExcellentTagInfo;
/* loaded from: classes4.dex */
public class a implements b, h {

    /* renamed from: e  reason: collision with root package name */
    public List<Object> f52848e;

    /* renamed from: f  reason: collision with root package name */
    public List<Object> f52849f;

    @Override // d.b.h0.g0.b.c
    public String getCacheKey() {
        return null;
    }

    @Override // d.b.h0.g0.b.b
    public boolean initByByteArray(byte[] bArr) {
        try {
            initByProtobuf((ExcFrsPageResIdl) new Wire(new Class[0]).parseFrom(bArr, ExcFrsPageResIdl.class));
            return true;
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // d.b.h0.g0.b.h
    public void initByJson(JSONObject jSONObject) {
    }

    @Override // d.b.h0.g0.b.h
    public void initByProtobuf(Message message) {
        ExcFrsPageResIdl excFrsPageResIdl;
        Error error;
        DataRes dataRes;
        if (!(message instanceof ExcFrsPageResIdl) || (excFrsPageResIdl = (ExcFrsPageResIdl) message) == null || (error = excFrsPageResIdl.error) == null || error.errorno.intValue() != 0 || (dataRes = excFrsPageResIdl.data) == null) {
            return;
        }
        if (dataRes.thread_list != null) {
            ArrayList arrayList = new ArrayList();
            this.f52848e = arrayList;
            arrayList.addAll(excFrsPageResIdl.data.thread_list);
        }
        excFrsPageResIdl.data.has_more.intValue();
        excFrsPageResIdl.data.pn.intValue();
        if (excFrsPageResIdl.data.tag_list != null) {
            this.f52849f = new ArrayList();
            for (ExcellentTagInfo excellentTagInfo : excFrsPageResIdl.data.tag_list) {
                if (excellentTagInfo != null) {
                    this.f52849f.add(excellentTagInfo);
                }
            }
        }
    }

    @Override // d.b.h0.g0.b.b
    public byte[] toCacheByteArray() {
        return null;
    }
}
