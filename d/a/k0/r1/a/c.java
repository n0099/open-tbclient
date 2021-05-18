package d.a.k0.r1.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.bubble.BubbleListData;
import d.a.c.e.p.k;
import d.a.j0.r.s.a;
import java.util.Date;
/* loaded from: classes3.dex */
public class c {

    /* loaded from: classes3.dex */
    public static class a implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f60279e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ BubbleListData.BubbleData f60280f;

        public a(e eVar, BubbleListData.BubbleData bubbleData) {
            this.f60279e = eVar;
            this.f60280f = bubbleData;
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            aVar.dismiss();
            e eVar = this.f60279e;
            if (eVar != null) {
                eVar.a(this.f60280f.getBcode());
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f60281e;

        public b(e eVar) {
            this.f60281e = eVar;
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            aVar.dismiss();
            e eVar = this.f60281e;
            if (eVar != null) {
                eVar.b();
            }
        }
    }

    /* renamed from: d.a.k0.r1.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1578c implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f60282e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ BubbleListData.BubbleData f60283f;

        public C1578c(e eVar, BubbleListData.BubbleData bubbleData) {
            this.f60282e = eVar;
            this.f60283f = bubbleData;
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            aVar.dismiss();
            e eVar = this.f60282e;
            if (eVar != null) {
                eVar.a(this.f60283f.getBcode());
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f60284e;

        public d(e eVar) {
            this.f60284e = eVar;
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            aVar.dismiss();
            e eVar = this.f60284e;
            if (eVar != null) {
                eVar.b();
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface e {
        void a(int i2);

        void b();
    }

    public static void a(TbPageContext<?> tbPageContext, BubbleListData.BubbleData bubbleData, e eVar) {
        if (bubbleData == null) {
            return;
        }
        d.a.j0.r.s.a aVar = new d.a.j0.r.s.a(tbPageContext.getPageActivity());
        aVar.setCanceledOnTouchOutside(false);
        Date date = new Date();
        Date date2 = new Date(date.getTime() + (bubbleData.getTime_interval() * 1000));
        String dateStringDay = k.getDateStringDay(date);
        String dateStringDay2 = k.getDateStringDay(date2);
        String format = String.format(tbPageContext.getResources().getString(R.string.bubble_free_dialog_text), bubbleData.getBname(), Integer.valueOf(bubbleData.getTime_interval() / 86400));
        View inflate = LayoutInflater.from(tbPageContext.getContext()).inflate(R.layout.bubble_free_dialog_content, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.tip1);
        TextView textView2 = (TextView) inflate.findViewById(R.id.tip2);
        SkinManager.setViewTextColor(textView, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(textView2, R.color.CAM_X0108, 1);
        textView.setText(format);
        textView2.setText(dateStringDay + tbPageContext.getString(R.string.to) + dateStringDay2);
        aVar.setContentView(inflate);
        aVar.setPositiveButton(R.string.use_immediately, new a(eVar, bubbleData));
        aVar.setNegativeButton(R.string.cancel, new b(eVar));
        aVar.create(tbPageContext);
        aVar.show();
    }

    public static void b(TbPageContext<?> tbPageContext, BubbleListData.BubbleData bubbleData, e eVar) {
        if (bubbleData == null) {
            return;
        }
        d.a.j0.r.s.a aVar = new d.a.j0.r.s.a(tbPageContext.getPageActivity());
        aVar.setCanceledOnTouchOutside(false);
        aVar.setMessage(String.format(tbPageContext.getString(R.string.bubble_pay_dialog_text), bubbleData.getLevel_name()));
        aVar.setPositiveButton(R.string.open_now, new C1578c(eVar, bubbleData));
        aVar.setNegativeButton(R.string.cancel, new d(eVar));
        aVar.create(tbPageContext);
        aVar.show();
    }
}
