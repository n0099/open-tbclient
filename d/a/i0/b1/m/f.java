package d.a.i0.b1.m;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class f extends ClickableSpan {

    /* renamed from: g  reason: collision with root package name */
    public int f48273g;

    /* renamed from: h  reason: collision with root package name */
    public String f48274h;

    /* renamed from: i  reason: collision with root package name */
    public String f48275i;
    public int j;

    /* renamed from: e  reason: collision with root package name */
    public int f48271e = -1;

    /* renamed from: f  reason: collision with root package name */
    public int f48272f = -1;
    public int k = 0;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f48276a;

        /* renamed from: b  reason: collision with root package name */
        public String f48277b;

        /* renamed from: c  reason: collision with root package name */
        public String f48278c;

        public a(int i2, String str, String str2) {
            this.f48276a = i2;
            this.f48277b = str;
            this.f48278c = str2;
        }
    }

    public f(int i2, String str) {
        this.f48274h = str;
        this.f48273g = i2;
    }

    public static void a(Context context, h hVar, int i2, String str, String str2) {
        if (hVar == null) {
            return;
        }
        if (i2 == 2) {
            hVar.onLinkClicked(context, str, false);
        } else if (i2 == 16) {
            hVar.onAtClicked(context, str);
        } else if (i2 == 18) {
            hVar.onLinkClicked(context, str, true);
        } else if (i2 == 32) {
            hVar.onVideoClicked(context, str);
        } else if (i2 == 64) {
            hVar.onSongClicked(context, str);
        } else if (i2 == 128) {
            hVar.onVideoP2PClicked(context, str);
        } else if (i2 == 256) {
            hVar.onPhoneClicked(context, str, str2);
        } else if (i2 != 1024) {
        } else {
            hVar.onLinkButtonClicked(context, str);
        }
    }

    public static void b(TbPageContext<?> tbPageContext, int i2, String str, String str2) {
        if (tbPageContext != null && (tbPageContext.getOrignalPage() instanceof h)) {
            a(tbPageContext.getPageActivity(), (h) tbPageContext.getOrignalPage(), i2, str, str2);
        }
    }

    public static void c(TbPageContext<?> tbPageContext, h hVar, int i2, String str, String str2) {
        if (tbPageContext == null || hVar == null) {
            return;
        }
        a(tbPageContext.getPageActivity(), hVar, i2, str, str2);
    }

    public String d() {
        return this.f48274h;
    }

    public boolean e() {
        int i2 = this.f48273g;
        return i2 == 2 || i2 == 16 || i2 == 18 || i2 == 39;
    }

    public final boolean f() {
        int i2 = this.f48273g;
        return i2 == 2 || i2 == 16 || i2 == 18 || i2 == 39;
    }

    public void g(int i2) {
        this.f48271e = i2;
    }

    public void h(int i2) {
        this.j = i2;
    }

    public void i(String str) {
        this.f48275i = str;
    }

    public void j(int i2) {
        this.f48272f = i2;
    }

    public void k(int i2) {
        this.k = i2;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001332, new a(this.f48273g, this.f48274h, this.f48275i));
        int i2 = 2;
        if (this.f48273g == 2) {
            int i3 = this.k;
            int i4 = 1;
            if (i3 == 1) {
                i2 = 1;
                i4 = 2;
            } else if (i3 == 2) {
                i2 = 1;
            }
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.PB_URL_CLICK_KEY).param("obj_source", i2).param("obj_type", i4));
        }
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        int i2 = this.f48272f;
        if (i2 != -1) {
            textPaint.setColor(SkinManager.getColor(i2));
        } else if (f()) {
            textPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0304));
        } else {
            textPaint.setColor(textPaint.linkColor);
        }
        textPaint.setUnderlineText(false);
        int i3 = this.f48271e;
        if (i3 != -1) {
            textPaint.bgColor = i3;
        } else if (this.j == 1 && e()) {
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                textPaint.bgColor = SkinManager.getColor(R.color.CAM_X0204);
            } else {
                textPaint.bgColor = SkinManager.getColor(R.color.cp_bg_line_z);
            }
        } else if (this.j == 2) {
            textPaint.bgColor = SkinManager.getColor(R.color.transparent);
        }
    }
}
