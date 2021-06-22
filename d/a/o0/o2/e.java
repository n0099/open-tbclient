package d.a.o0.o2;

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
import d.a.o0.o2.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class e extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f61695e;

    /* renamed from: h  reason: collision with root package name */
    public String f61698h;

    /* renamed from: i  reason: collision with root package name */
    public String f61699i;

    /* renamed from: g  reason: collision with root package name */
    public int f61697g = -1;

    /* renamed from: f  reason: collision with root package name */
    public final List<b.a> f61696f = new ArrayList();

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a f61700e;

        public a(b.a aVar) {
            this.f61700e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.f61695e == null) {
                return;
            }
            e.this.g(this.f61700e);
            if (this.f61700e.f61667g == 1) {
                SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(e.this.f61695e.getPageActivity()).createSubPbActivityConfig(this.f61700e.f61666f + "", this.f61700e.f61661a + "", "search_post", true);
                createSubPbActivityConfig.setKeyPageStartFrom(8);
                e.this.f61695e.sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
                return;
            }
            PbActivityConfig createNormalCfg = new PbActivityConfig(e.this.f61695e.getPageActivity()).createNormalCfg(this.f61700e.f61666f + "", this.f61700e.f61661a + "", "search_post");
            createNormalCfg.setStartFrom(8);
            createNormalCfg.setSortType(0);
            e.this.f61695e.sendMessage(new CustomMessage(2004001, createNormalCfg));
        }
    }

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public TextView f61702a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f61703b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f61704c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f61705d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f61706e;

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
        this.f61695e = tbPageContext;
    }

    public void c(List<b.a> list) {
        this.f61696f.clear();
        this.f61696f.addAll(list);
    }

    public void d(String str) {
        this.f61699i = str;
    }

    public void e(String str) {
        this.f61698h = str;
    }

    public void f(int i2) {
        this.f61697g = i2;
    }

    public final void g(b.a aVar) {
        StatisticItem param = new StatisticItem("c12405").param("fname", aVar.f61665e).param("uid", TbadkCoreApplication.getCurrentAccount());
        int i2 = this.f61697g;
        if (i2 > 0) {
            param.param("tab_id", i2);
        }
        if (aVar != null) {
            if (aVar.f61667g != 1 && aVar.f61668h != 1) {
                param.param("tid", aVar.f61666f);
            } else {
                param.param("pid", aVar.f61661a);
            }
            param.param("fid", this.f61699i);
            param.param("query", this.f61698h);
        }
        TiebaStatic.log(param);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<b.a> list = this.f61696f;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        List<b.a> list = this.f61696f;
        if (list == null || list.isEmpty() || i2 < 0 || i2 >= this.f61696f.size()) {
            return null;
        }
        return this.f61696f.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.f61695e.getPageActivity()).inflate(R.layout.post_search_list_item, (ViewGroup) null);
            b bVar = new b(null);
            bVar.f61702a = (TextView) view.findViewById(R.id.title_text);
            bVar.f61703b = (TextView) view.findViewById(R.id.content_text);
            bVar.f61704c = (TextView) view.findViewById(R.id.label_text);
            bVar.f61705d = (TextView) view.findViewById(R.id.user_name);
            bVar.f61706e = (TextView) view.findViewById(R.id.time_text);
            view.setTag(bVar);
        }
        b bVar2 = (b) view.getTag();
        b.a aVar = this.f61696f.get(i2);
        if (aVar == null) {
            return view;
        }
        String str = TbadkCoreApplication.getInst().getSkinType() == 1 ? "#99260f" : "#e53917";
        bVar2.f61702a.setText(Html.fromHtml(StringHelper.getHighLightString(aVar.f61662b, str)));
        bVar2.f61703b.setText(Html.fromHtml(StringHelper.getHighLightString(aVar.f61664d, str)));
        bVar2.f61705d.setText(aVar.f61669i);
        bVar2.f61706e.setText(StringHelper.getFormatTime(aVar.f61663c));
        bVar2.f61704c.setVisibility(0);
        if (aVar.f61667g == 1) {
            bVar2.f61704c.setText(R.string.floor_text);
        } else if (aVar.f61668h == 1) {
            bVar2.f61704c.setText(R.string.reply_post);
        } else {
            bVar2.f61704c.setVisibility(8);
        }
        view.setOnClickListener(new a(aVar));
        SkinManager.setBackgroundColor(view, R.color.CAM_X0201);
        d.a.n0.s0.a.a(this.f61695e, view);
        h(aVar);
        return view;
    }

    public final void h(b.a aVar) {
        StatisticItem param = new StatisticItem("c14171").param("fname", aVar.f61665e).param("uid", TbadkCoreApplication.getCurrentAccount());
        int i2 = this.f61697g;
        if (i2 > 0) {
            param.param("tab_id", i2);
        }
        if (aVar != null) {
            if (aVar.f61667g != 1 && aVar.f61668h != 1) {
                param.param("tid", aVar.f61666f);
            } else {
                param.param("pid", aVar.f61661a);
            }
            param.param("fid", this.f61699i);
            param.param("query", this.f61698h);
        }
        TiebaStatic.log(param);
    }
}
