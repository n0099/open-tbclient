package d.b.i0.y.a.d;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.chosen.posts.request.ChosenPostCacheModel;
import com.squareup.wire.Message;
import com.squareup.wire.Wire;
import d.b.h0.g0.b.h;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import tbclient.Error;
import tbclient.HotThread.HotThreadResIdl;
import tbclient.HotThread.Pic;
import tbclient.HotThread.tinfo;
/* loaded from: classes4.dex */
public class b implements h, d.b.h0.g0.b.b {

    /* renamed from: e  reason: collision with root package name */
    public List<tinfo> f64005e;

    public List<tinfo> b() {
        List<tinfo> list = this.f64005e;
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (tinfo tinfoVar : this.f64005e) {
            if (c(tinfoVar)) {
                arrayList.add(tinfoVar);
            }
        }
        return arrayList;
    }

    public final boolean c(tinfo tinfoVar) {
        if (tinfoVar == null) {
            return false;
        }
        List<Pic> list = tinfoVar.pics;
        if (list == null || list.size() <= 0) {
            return (StringUtils.isNull(tinfoVar.title) && StringUtils.isNull(tinfoVar._abstract)) ? false : true;
        }
        return true;
    }

    @Override // d.b.h0.g0.b.c
    public String getCacheKey() {
        return ChosenPostCacheModel.CACHE_KEY;
    }

    @Override // d.b.h0.g0.b.b
    public boolean initByByteArray(byte[] bArr) {
        try {
            initByProtobuf((HotThreadResIdl) new Wire(new Class[0]).parseFrom(bArr, HotThreadResIdl.class));
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // d.b.h0.g0.b.h
    public void initByJson(JSONObject jSONObject) {
    }

    @Override // d.b.h0.g0.b.h
    public void initByProtobuf(Message message) {
        if (message instanceof HotThreadResIdl) {
            HotThreadResIdl hotThreadResIdl = (HotThreadResIdl) message;
            Error error = hotThreadResIdl.error;
            this.f64005e = hotThreadResIdl.data.hot_thread;
        }
    }

    @Override // d.b.h0.g0.b.b
    public byte[] toCacheByteArray() {
        return null;
    }
}
