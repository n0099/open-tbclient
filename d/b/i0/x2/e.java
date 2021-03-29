package d.b.i0.x2;

import com.baidu.android.bdutil.cuid.sdk.AppCuidRuntime;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
@Singleton
@Service
/* loaded from: classes5.dex */
public class e implements d.b.l.c.c {

    /* renamed from: a  reason: collision with root package name */
    public static String f62518a = "";

    @Override // d.b.l.c.c
    public String a(String str, boolean z) {
        return str;
    }

    @Override // d.b.l.c.c
    public String getBDVCInfo() {
        return null;
    }

    @Override // d.b.l.c.c
    public String getC3Aid() {
        return null;
    }

    @Override // d.b.l.c.c
    public String getCfrom() {
        return TbConfig.getCurrentFrom();
    }

    @Override // d.b.l.c.c
    public String getDeviceId() {
        return AppCuidRuntime.getAppCuidManager().getCuid();
    }

    @Override // d.b.l.c.c
    public String getFrom() {
        return TbConfig.getCurrentFrom();
    }

    @Override // d.b.l.c.c
    public String getSchemeHeader() {
        return null;
    }

    @Override // d.b.l.c.c
    public String getSid() {
        return TbSingleton.getInstance().getSampleId();
    }

    @Override // d.b.l.c.c
    public String getZid() {
        return f62518a;
    }
}
