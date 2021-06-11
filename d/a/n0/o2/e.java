package d.a.n0.o2;

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
import d.a.n0.o2.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class e extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f61570e;

    /* renamed from: h  reason: collision with root package name */
    public String f61573h;

    /* renamed from: i  reason: collision with root package name */
    public String f61574i;

    /* renamed from: g  reason: collision with root package name */
    public int f61572g = -1;

    /* renamed from: f  reason: collision with root package name */
    public final List<b.a> f61571f = new ArrayList();

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a f61575e;

        public a(b.a aVar) {
            this.f61575e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.f61570e == null) {
                return;
            }
            e.this.g(this.f61575e);
            if (this.f61575e.f61542g == 1) {
                SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(e.this.f61570e.getPageActivity()).createSubPbActivityConfig(this.f61575e.f61541f + "", this.f61575e.f61536a + "", "search_post", true);
                createSubPbActivityConfig.setKeyPageStartFrom(8);
                e.this.f61570e.sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
                return;
            }
            PbActivityConfig createNormalCfg = new PbActivityConfig(e.this.f61570e.getPageActivity()).createNormalCfg(this.f61575e.f61541f + "", this.f61575e.f61536a + "", "search_post");
            createNormalCfg.setStartFrom(8);
            createNormalCfg.setSortType(0);
            e.this.f61570e.sendMessage(new CustomMessage(2004001, createNormalCfg));
        }
    }

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f61577a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f61578b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f61579c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f61580d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f61581e;

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
        this.f61570e = tbPageContext;
    }

    public void c(List<b.a> list) {
        this.f61571f.clear();
        this.f61571f.addAll(list);
    }

    public void d(String str) {
        this.f61574i = str;
    }

    public void e(String str) {
        this.f61573h = str;
    }

    public void f(int i2) {
        this.f61572g = i2;
    }

    public final void g(b.a aVar) {
        StatisticItem param = new StatisticItem("c12405").param("fname", aVar.f61540e).param("uid", TbadkCoreApplication.getCurrentAccount());
        int i2 = this.f61572g;
        if (i2 > 0) {
            param.param("tab_id", i2);
        }
        if (aVar != null) {
            if (aVar.f61542g != 1 && aVar.f61543h != 1) {
                param.param("tid", aVar.f61541f);
            } else {
                param.param("pid", aVar.f61536a);
            }
            param.param("fid", this.f61574i);
            param.param("query", this.f61573h);
        }
        TiebaStatic.log(param);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<b.a> list = this.f61571f;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        List<b.a> list = this.f61571f;
        if (list == null || list.isEmpty() || i2 < 0 || i2 >= this.f61571f.size()) {
            return null;
        }
        return this.f61571f.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.f61570e.getPageActivity()).inflate(R.layout.post_search_list_item, (ViewGroup) null);
            b bVar = new b(null);
            bVar.f61577a = (TextView) view.findViewById(R.id.title_text);
            bVar.f61578b = (TextView) view.findViewById(R.id.content_text);
            bVar.f61579c = (TextView) view.findViewById(R.id.label_text);
            bVar.f61580d = (TextView) view.findViewById(R.id.user_name);
            bVar.f61581e = (TextView) view.findViewById(R.id.time_text);
            view.setTag(bVar);
        }
        b bVar2 = (b) view.getTag();
        b.a aVar = this.f61571f.get(i2);
        if (aVar == null) {
            return view;
        }
        String str = TbadkCoreApplication.getInst().getSkinType() == 1 ? "#99260f" : "#e53917";
        bVar2.f61577a.setText(Html.fromHtml(StringHelper.getHighLightString(aVar.f61537b, str)));
        bVar2.f61578b.setText(Html.fromHtml(StringHelper.getHighLightString(aVar.f61539d, str)));
        bVar2.f61580d.setText(aVar.f61544i);
        bVar2.f61581e.setText(StringHelper.getFormatTime(aVar.f61538c));
        bVar2.f61579c.setVisibility(0);
        if (aVar.f61542g == 1) {
            bVar2.f61579c.setText(R.string.floor_text);
        } else if (aVar.f61543h == 1) {
            bVar2.f61579c.setText(R.string.reply_post);
        } else {
            bVar2.f61579c.setVisibility(8);
        }
        view.setOnClickListener(new a(aVar));
        SkinManager.setBackgroundColor(view, R.color.CAM_X0201);
        d.a.m0.s0.a.a(this.f61570e, view);
        h(aVar);
        return view;
    }

    public final void h(b.a aVar) {
        StatisticItem param = new StatisticItem("c14171").param("fname", aVar.f61540e).param("uid", TbadkCoreApplication.getCurrentAccount());
        int i2 = this.f61572g;
        if (i2 > 0) {
            param.param("tab_id", i2);
        }
        if (aVar != null) {
            if (aVar.f61542g != 1 && aVar.f61543h != 1) {
                param.param("tid", aVar.f61541f);
            } else {
                param.param("pid", aVar.f61536a);
            }
            param.param("fid", this.f61574i);
            param.param("query", this.f61573h);
        }
        TiebaStatic.log(param);
    }
}
