package d.b.i0.n2;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import d.b.i0.n2.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class e extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f58560e;

    /* renamed from: g  reason: collision with root package name */
    public int f58562g = -1;

    /* renamed from: f  reason: collision with root package name */
    public List<b.a> f58561f = new ArrayList();

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a f58563e;

        public a(b.a aVar) {
            this.f58563e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.f58560e == null) {
                return;
            }
            e.this.e(this.f58563e);
            if (this.f58563e.f58535g == 1) {
                SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(e.this.f58560e.getPageActivity()).createSubPbActivityConfig(this.f58563e.f58534f + "", this.f58563e.f58529a + "", "search_post", true);
                createSubPbActivityConfig.setKeyPageStartFrom(8);
                e.this.f58560e.sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
                return;
            }
            PbActivityConfig createNormalCfg = new PbActivityConfig(e.this.f58560e.getPageActivity()).createNormalCfg(this.f58563e.f58534f + "", this.f58563e.f58529a + "", "search_post");
            createNormalCfg.setStartFrom(8);
            createNormalCfg.setSortType(0);
            e.this.f58560e.sendMessage(new CustomMessage(2004001, createNormalCfg));
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f58565a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f58566b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f58567c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f58568d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f58569e;

        public b() {
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    static {
        TbadkCoreApplication.getInst().getListItemRule().c();
    }

    public e(TbPageContext<?> tbPageContext) {
        this.f58560e = tbPageContext;
    }

    public void c(List<b.a> list) {
        this.f58561f = list;
    }

    public void d(int i) {
        this.f58562g = i;
    }

    public final void e(b.a aVar) {
        StatisticItem param = new StatisticItem("c12405").param("fname", aVar.f58533e).param("uid", TbadkCoreApplication.getCurrentAccount());
        int i = this.f58562g;
        if (i > 0) {
            param.param("tab_id", i);
        }
        if (aVar != null) {
            if (aVar.f58535g != 1 && aVar.f58536h != 1) {
                param.param("tid", aVar.f58534f);
            } else {
                param.param("pid", aVar.f58529a);
            }
        }
        TiebaStatic.log(param);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<b.a> list = this.f58561f;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        List<b.a> list = this.f58561f;
        if (list == null || list.isEmpty() || i < 0 || i >= this.f58561f.size()) {
            return null;
        }
        return this.f58561f.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.f58560e.getPageActivity()).inflate(R.layout.post_search_list_item, (ViewGroup) null);
            b bVar = new b(null);
            bVar.f58565a = (TextView) view.findViewById(R.id.title_text);
            bVar.f58566b = (TextView) view.findViewById(R.id.content_text);
            bVar.f58567c = (TextView) view.findViewById(R.id.label_text);
            bVar.f58568d = (TextView) view.findViewById(R.id.user_name);
            bVar.f58569e = (TextView) view.findViewById(R.id.time_text);
            view.setTag(bVar);
        }
        b bVar2 = (b) view.getTag();
        b.a aVar = this.f58561f.get(i);
        if (aVar == null) {
            return view;
        }
        String str = TbadkCoreApplication.getInst().getSkinType() == 1 ? "#99260f" : "#e53917";
        bVar2.f58565a.setText(Html.fromHtml(StringHelper.getHighLightString(aVar.f58530b, str)));
        bVar2.f58566b.setText(Html.fromHtml(StringHelper.getHighLightString(aVar.f58532d, str)));
        bVar2.f58568d.setText(aVar.i);
        bVar2.f58569e.setText(StringHelper.getFormatTime(aVar.f58531c));
        bVar2.f58567c.setVisibility(0);
        if (aVar.f58535g == 1) {
            bVar2.f58567c.setText(R.string.floor_text);
        } else if (aVar.f58536h == 1) {
            bVar2.f58567c.setText(R.string.reply_post);
        } else {
            bVar2.f58567c.setVisibility(8);
        }
        view.setOnClickListener(new a(aVar));
        SkinManager.setBackgroundColor(view, R.color.CAM_X0201);
        d.b.h0.s0.a.a(this.f58560e, view);
        return view;
    }
}
