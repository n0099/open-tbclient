package d.b.i0.z0.g.j;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.homepage.personalize.data.RecPersonalizeRequest;
import com.squareup.wire.Wire;
import d.b.b.e.d.l;
import java.io.IOException;
import tbclient.Personalized.DataRes;
/* loaded from: classes3.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f63195a = false;

    public static void a() {
        l<byte[]> e2 = d.b.h0.r.r.a.f().e("tb.rec_old_data", TbadkCoreApplication.getCurrentAccount());
        if (e2 != null) {
            e2.e("0", new byte[0], 0L);
        }
    }

    public static DataRes b() {
        byte[] bArr;
        l<byte[]> e2 = d.b.h0.r.r.a.f().e("tb.rec_old_data", TbadkCoreApplication.getCurrentAccount());
        if (e2 != null && (bArr = e2.get("0")) != null && bArr.length != 0) {
            try {
                return (DataRes) new Wire(new Class[0]).parseFrom(bArr, DataRes.class);
            } catch (IOException e3) {
                BdLog.e(e3);
            }
        }
        return null;
    }

    public static boolean c(ResponsedMessage responsedMessage) {
        return responsedMessage != null && responsedMessage.getOrginalMessage() != null && (responsedMessage.getOrginalMessage().getExtra() instanceof RecPersonalizeRequest) && ((RecPersonalizeRequest) responsedMessage.getOrginalMessage().getExtra()).getLoadType() == 2;
    }
}
