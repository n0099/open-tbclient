package d.a.n0.r0.f2.a;

import com.squareup.wire.Message;
import d.a.m0.g0.b.h;
import org.json.JSONObject;
import tbclient.Error;
import tbclient.ZoneRight.DataRes;
import tbclient.ZoneRight.Toast;
import tbclient.ZoneRight.ZoneRightResIdl;
/* loaded from: classes4.dex */
public class b implements h {

    /* renamed from: e  reason: collision with root package name */
    public boolean f62253e;

    /* renamed from: f  reason: collision with root package name */
    public int f62254f;

    /* renamed from: g  reason: collision with root package name */
    public String f62255g;

    /* renamed from: h  reason: collision with root package name */
    public int f62256h;

    /* renamed from: i  reason: collision with root package name */
    public String f62257i;

    @Override // d.a.m0.g0.b.h
    public void initByJson(JSONObject jSONObject) {
    }

    @Override // d.a.m0.g0.b.h
    public void initByProtobuf(Message message) {
        if (message instanceof ZoneRightResIdl) {
            ZoneRightResIdl zoneRightResIdl = (ZoneRightResIdl) message;
            Error error = zoneRightResIdl.error;
            if (error != null) {
                this.f62254f = error.errorno.intValue();
                this.f62255g = zoneRightResIdl.error.usermsg;
            }
            DataRes dataRes = zoneRightResIdl.data;
            if (dataRes != null) {
                this.f62253e = dataRes.has_right.intValue() == 1;
                Toast toast = zoneRightResIdl.data.toast;
                if (toast != null) {
                    this.f62256h = toast.type.intValue();
                    this.f62257i = zoneRightResIdl.data.toast.content;
                }
            }
        }
    }
}
