package d.a.n0.z0;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Looper;
import android.os.Message;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes3.dex */
public class u {
    public static final boolean a(boolean z) {
        Object d2;
        Intent intent;
        ComponentName component;
        Object d3 = d.a.c.e.b.a.a.d(Looper.myQueue(), "mMessages");
        if (d3 != null && (d3 instanceof Message)) {
            Message message = (Message) d3;
            int i2 = 0;
            while (message != null) {
                Object obj = message.obj;
                if (obj == null || i2 >= 10) {
                    break;
                }
                i2++;
                if (obj != null && (d2 = d.a.c.e.b.a.a.d(obj, "intent")) != null && (d2 instanceof Intent) && (component = (intent = (Intent) d2).getComponent()) != null) {
                    try {
                        Class.forName(component.getClassName());
                    } catch (Throwable unused) {
                        StatisticItem statisticItem = new StatisticItem("check_change_intent_tologo");
                        StringBuilder sb = new StringBuilder();
                        sb.append(i2 == 1);
                        sb.append("");
                        TiebaStatic.log(statisticItem.param("obj_param1", sb.toString()).param(TiebaStatic.Params.OBJ_PARAM2, component.getClassName()));
                        if (z && i2 == 1) {
                            intent.setClassName(TbadkCoreApplication.getInst(), "com.baidu.tieba.LogoActivity");
                        }
                        return false;
                    }
                }
                Object d4 = d.a.c.e.b.a.a.d(message, UnitedSchemeConstants.UNITED_SCHEME_NEXT);
                message = (d4 == null || !(d4 instanceof Message)) ? null : (Message) d4;
            }
        }
        return true;
    }

    public static final boolean b() {
        Object d2 = d.a.c.e.b.a.a.d(Looper.myQueue(), "mMessages");
        boolean z = false;
        if (d2 != null && (d2 instanceof Message)) {
            Message message = (Message) d2;
            int i2 = 0;
            while (message != null && message.obj != null && !z && i2 < 10) {
                i2++;
                z = c(message);
                Object d3 = d.a.c.e.b.a.a.d(message, UnitedSchemeConstants.UNITED_SCHEME_NEXT);
                message = (d3 == null || !(d3 instanceof Message)) ? null : (Message) d3;
            }
        }
        return z;
    }

    public static final boolean c(Message message) {
        Object obj;
        Object d2;
        ComponentName component;
        return (message == null || (obj = message.obj) == null || (d2 = d.a.c.e.b.a.a.d(obj, "intent")) == null || !(d2 instanceof Intent) || (component = ((Intent) d2).getComponent()) == null || !"com.baidu.tieba.LogoActivity".equals(component.getClassName())) ? false : true;
    }
}
