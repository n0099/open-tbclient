package d.b.j0.n2;

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
import d.b.j0.n2.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class e extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f58981e;

    /* renamed from: g  reason: collision with root package name */
    public int f58983g = -1;

    /* renamed from: f  reason: collision with root package name */
    public List<b.a> f58982f = new ArrayList();

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a f58984e;

        public a(b.a aVar) {
            this.f58984e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.f58981e == null) {
                return;
            }
            e.this.e(this.f58984e);
            if (this.f58984e.f58956g == 1) {
                SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(e.this.f58981e.getPageActivity()).createSubPbActivityConfig(this.f58984e.f58955f + "", this.f58984e.f58950a + "", "search_post", true);
                createSubPbActivityConfig.setKeyPageStartFrom(8);
                e.this.f58981e.sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
                return;
            }
            PbActivityConfig createNormalCfg = new PbActivityConfig(e.this.f58981e.getPageActivity()).createNormalCfg(this.f58984e.f58955f + "", this.f58984e.f58950a + "", "search_post");
            createNormalCfg.setStartFrom(8);
            createNormalCfg.setSortType(0);
            e.this.f58981e.sendMessage(new CustomMessage(2004001, createNormalCfg));
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f58986a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f58987b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f58988c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f58989d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f58990e;

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
        this.f58981e = tbPageContext;
    }

    public void c(List<b.a> list) {
        this.f58982f = list;
    }

    public void d(int i) {
        this.f58983g = i;
    }

    public final void e(b.a aVar) {
        StatisticItem param = new StatisticItem("c12405").param("fname", aVar.f58954e).param("uid", TbadkCoreApplication.getCurrentAccount());
        int i = this.f58983g;
        if (i > 0) {
            param.param("tab_id", i);
        }
        if (aVar != null) {
            if (aVar.f58956g != 1 && aVar.f58957h != 1) {
                param.param("tid", aVar.f58955f);
            } else {
                param.param("pid", aVar.f58950a);
            }
        }
        TiebaStatic.log(param);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<b.a> list = this.f58982f;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        List<b.a> list = this.f58982f;
        if (list == null || list.isEmpty() || i < 0 || i >= this.f58982f.size()) {
            return null;
        }
        return this.f58982f.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.f58981e.getPageActivity()).inflate(R.layout.post_search_list_item, (ViewGroup) null);
            b bVar = new b(null);
            bVar.f58986a = (TextView) view.findViewById(R.id.title_text);
            bVar.f58987b = (TextView) view.findViewById(R.id.content_text);
            bVar.f58988c = (TextView) view.findViewById(R.id.label_text);
            bVar.f58989d = (TextView) view.findViewById(R.id.user_name);
            bVar.f58990e = (TextView) view.findViewById(R.id.time_text);
            view.setTag(bVar);
        }
        b bVar2 = (b) view.getTag();
        b.a aVar = this.f58982f.get(i);
        if (aVar == null) {
            return view;
        }
        String str = TbadkCoreApplication.getInst().getSkinType() == 1 ? "#99260f" : "#e53917";
        bVar2.f58986a.setText(Html.fromHtml(StringHelper.getHighLightString(aVar.f58951b, str)));
        bVar2.f58987b.setText(Html.fromHtml(StringHelper.getHighLightString(aVar.f58953d, str)));
        bVar2.f58989d.setText(aVar.i);
        bVar2.f58990e.setText(StringHelper.getFormatTime(aVar.f58952c));
        bVar2.f58988c.setVisibility(0);
        if (aVar.f58956g == 1) {
            bVar2.f58988c.setText(R.string.floor_text);
        } else if (aVar.f58957h == 1) {
            bVar2.f58988c.setText(R.string.reply_post);
        } else {
            bVar2.f58988c.setVisibility(8);
        }
        view.setOnClickListener(new a(aVar));
        SkinManager.setBackgroundColor(view, R.color.CAM_X0201);
        d.b.i0.s0.a.a(this.f58981e, view);
        return view;
    }
}
