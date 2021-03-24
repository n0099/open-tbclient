package d.b.h0.b1.m;

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
    public int f49976g;

    /* renamed from: h  reason: collision with root package name */
    public String f49977h;
    public String i;
    public int j;

    /* renamed from: e  reason: collision with root package name */
    public int f49974e = -1;

    /* renamed from: f  reason: collision with root package name */
    public int f49975f = -1;
    public int k = 0;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f49978a;

        /* renamed from: b  reason: collision with root package name */
        public String f49979b;

        /* renamed from: c  reason: collision with root package name */
        public String f49980c;

        public a(int i, String str, String str2) {
            this.f49978a = i;
            this.f49979b = str;
            this.f49980c = str2;
        }
    }

    public f(int i, String str) {
        this.f49977h = str;
        this.f49976g = i;
    }

    public static void a(Context context, h hVar, int i, String str, String str2) {
        if (hVar == null) {
            return;
        }
        if (i == 2) {
            hVar.onLinkClicked(context, str, false);
        } else if (i == 16) {
            hVar.onAtClicked(context, str);
        } else if (i == 18) {
            hVar.onLinkClicked(context, str, true);
        } else if (i == 32) {
            hVar.onVideoClicked(context, str);
        } else if (i == 64) {
            hVar.onSongClicked(context, str);
        } else if (i == 128) {
            hVar.onVideoP2PClicked(context, str);
        } else if (i == 256) {
            hVar.onPhoneClicked(context, str, str2);
        } else if (i != 1024) {
        } else {
            hVar.onLinkButtonClicked(context, str);
        }
    }

    public static void b(TbPageContext<?> tbPageContext, int i, String str, String str2) {
        if (tbPageContext != null && (tbPageContext.getOrignalPage() instanceof h)) {
            a(tbPageContext.getPageActivity(), (h) tbPageContext.getOrignalPage(), i, str, str2);
        }
    }

    public static void c(TbPageContext<?> tbPageContext, h hVar, int i, String str, String str2) {
        if (tbPageContext == null || hVar == null) {
            return;
        }
        a(tbPageContext.getPageActivity(), hVar, i, str, str2);
    }

    public String d() {
        return this.f49977h;
    }

    public boolean e() {
        int i = this.f49976g;
        return i == 2 || i == 16 || i == 18 || i == 39;
    }

    public final boolean f() {
        int i = this.f49976g;
        return i == 2 || i == 16 || i == 18 || i == 39;
    }

    public void g(int i) {
        this.f49974e = i;
    }

    public void h(int i) {
        this.j = i;
    }

    public void i(String str) {
        this.i = str;
    }

    public void j(int i) {
        this.f49975f = i;
    }

    public void k(int i) {
        this.k = i;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001332, new a(this.f49976g, this.f49977h, this.i));
        int i = 2;
        if (this.f49976g == 2) {
            int i2 = this.k;
            int i3 = 1;
            if (i2 == 1) {
                i = 1;
                i3 = 2;
            } else if (i2 == 2) {
                i = 1;
            }
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.PB_URL_CLICK_KEY).param("obj_source", i).param("obj_type", i3));
        }
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        int i = this.f49975f;
        if (i != -1) {
            textPaint.setColor(SkinManager.getColor(i));
        } else if (f()) {
            textPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0304));
        } else {
            textPaint.setColor(textPaint.linkColor);
        }
        textPaint.setUnderlineText(false);
        int i2 = this.f49974e;
        if (i2 != -1) {
            textPaint.bgColor = i2;
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
