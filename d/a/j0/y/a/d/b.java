package d.a.j0.y.a.d;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.chosen.posts.request.ChosenPostCacheModel;
import com.squareup.wire.Message;
import com.squareup.wire.Wire;
import d.a.i0.g0.b.h;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import tbclient.Error;
import tbclient.HotThread.HotThreadResIdl;
import tbclient.HotThread.Pic;
import tbclient.HotThread.tinfo;
/* loaded from: classes4.dex */
public class b implements h, d.a.i0.g0.b.b {

    /* renamed from: e  reason: collision with root package name */
    public List<tinfo> f62700e;

    public List<tinfo> a() {
        List<tinfo> list = this.f62700e;
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (tinfo tinfoVar : this.f62700e) {
            if (b(tinfoVar)) {
                arrayList.add(tinfoVar);
            }
        }
        return arrayList;
    }

    public final boolean b(tinfo tinfoVar) {
        if (tinfoVar == null) {
            return false;
        }
        List<Pic> list = tinfoVar.pics;
        if (list == null || list.size() <= 0) {
            return (StringUtils.isNull(tinfoVar.title) && StringUtils.isNull(tinfoVar._abstract)) ? false : true;
        }
        return true;
    }

    @Override // d.a.i0.g0.b.c
    public String getCacheKey() {
        return ChosenPostCacheModel.CACHE_KEY;
    }

    @Override // d.a.i0.g0.b.b
    public boolean initByByteArray(byte[] bArr) {
        try {
            initByProtobuf((HotThreadResIdl) new Wire(new Class[0]).parseFrom(bArr, HotThreadResIdl.class));
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // d.a.i0.g0.b.h
    public void initByJson(JSONObject jSONObject) {
    }

    @Override // d.a.i0.g0.b.h
    public void initByProtobuf(Message message) {
        if (message instanceof HotThreadResIdl) {
            HotThreadResIdl hotThreadResIdl = (HotThreadResIdl) message;
            Error error = hotThreadResIdl.error;
            this.f62700e = hotThreadResIdl.data.hot_thread;
        }
    }

    @Override // d.a.i0.g0.b.b
    public byte[] toCacheByteArray() {
        return null;
    }
}
