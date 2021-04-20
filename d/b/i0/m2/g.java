package d.b.i0.m2;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.post.ReplyLinearLayout;
import d.b.c.j.e.n;
import d.b.i0.m2.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class g extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public PersonPostModel.c f58376e;

    /* renamed from: f  reason: collision with root package name */
    public PersonPostModel f58377f;

    /* renamed from: g  reason: collision with root package name */
    public final String f58378g;

    /* renamed from: h  reason: collision with root package name */
    public BdUniqueId f58379h;
    public String i;
    public TbPageContext<BaseFragmentActivity> j;
    public final PersonPostModel.c k = new a();
    public final a.InterfaceC1393a l = new b();

    /* loaded from: classes3.dex */
    public class a implements PersonPostModel.c {
        public a() {
        }

        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.c
        public void p0(PersonPostModel personPostModel, boolean z) {
            if (z) {
                g.this.f58377f = personPostModel;
                Iterator<n> it = g.this.f58377f.postList.iterator();
                while (it.hasNext()) {
                    n next = it.next();
                    if (next != null && !(next instanceof PersonPostModel.PostInfoList)) {
                        it.remove();
                    }
                }
            } else if (g.this.f58377f != null) {
                for (int i = 0; i < personPostModel.postList.size(); i++) {
                    if (personPostModel.postList.get(i) instanceof PersonPostModel.PostInfoList) {
                        g.this.f58377f.postList.add(personPostModel.postList.get(i));
                    }
                }
            }
            if (g.this.f58376e != null) {
                g.this.f58376e.p0(personPostModel, z);
            }
            g.this.notifyDataSetChanged();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements a.InterfaceC1393a {
        public b() {
        }

        @Override // d.b.i0.m2.a.InterfaceC1393a
        public void a(View view) {
            String[] strArr;
            int id = view.getId();
            if (id == R.id.portrait) {
                ((BaseFragmentActivity) g.this.j.getOrignalPage()).finish();
            } else if (id == R.id.username) {
                ((BaseFragmentActivity) g.this.j.getOrignalPage()).finish();
            } else if ((id == R.id.item_header || id == R.id.original_post_title || id == R.id.item_footer || id == R.id.reply_count) && (strArr = (String[]) view.getTag()) != null) {
                if (!"0".equals(strArr[2]) && strArr[1] != null) {
                    SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(g.this.j.getPageActivity()).createSubPbActivityConfig(strArr[0], strArr[1], "person_post_reply", false);
                    createSubPbActivityConfig.setKeyPageStartFrom(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
                    return;
                }
                PbActivityConfig createNormalCfg = new PbActivityConfig(g.this.j.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_page");
                createNormalCfg.setStartFrom(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    /* loaded from: classes3.dex */
    public static class c extends d.b.i0.m2.a {
        public ReplyLinearLayout v;
        public TextView w;
        public View x;
        public View y;

        public c(View view, TbPageContext<BaseFragmentActivity> tbPageContext) {
            super(view, tbPageContext);
            this.v = (ReplyLinearLayout) view.findViewById(R.id.content_container);
            this.w = (TextView) view.findViewById(R.id.original_post_title);
            this.x = view.findViewById(R.id.reply_top_line);
            this.y = view.findViewById(R.id.reply_bottom_line);
            this.w.setOnClickListener(this);
        }

        @Override // d.b.i0.m2.a
        public void a(int i) {
            super.a(i);
            SkinManager.setBackgroundResource(this.w, R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.w, R.color.CAM_X0105, 1);
            SkinManager.setBackgroundResource(this.x, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.y, R.color.CAM_X0204);
        }
    }

    public g(TbPageContext<BaseFragmentActivity> tbPageContext, String str, String str2, BdUniqueId bdUniqueId) {
        this.j = tbPageContext;
        this.f58378g = str;
        this.f58379h = bdUniqueId;
    }

    public void e() {
        PersonPostModel personPostModel = this.f58377f;
        if (personPostModel != null) {
            personPostModel.cancelLoadData();
        }
    }

    public void f(boolean z) {
        if (this.f58377f == null) {
            PersonPostModel personPostModel = new PersonPostModel(this.j, this.f58379h, null, true, PersonPostModel.FROM_PERSON_POST);
            this.f58377f = personPostModel;
            personPostModel.setUniqueId(this.f58379h);
        }
        this.f58377f.fetchPost(this.j, this.k, z, this.f58378g, false, true, false, null);
    }

    public final void g(int i, c cVar, ViewGroup viewGroup) {
        PersonPostModel.PostInfoList h2 = h(i);
        if (this.i == null) {
            this.i = h2.user_portrait;
        }
        cVar.d(h2, false, this.i);
        ArrayList<String[]> arrayList = new ArrayList<>();
        int length = h2.content.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (h2.content[i2].post_content.length != 0) {
                StringBuffer stringBuffer = new StringBuffer();
                if (!h2.content[i2].post_content[0].text.startsWith("回复 ")) {
                    stringBuffer.append("回复：");
                }
                int length2 = h2.content[i2].post_content.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    stringBuffer.append(h2.content[i2].post_content[i3].text);
                }
                arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(h2.thread_id), String.valueOf(h2.content[i2].post_id), String.valueOf(h2.content[i2].post_type), StringHelper.getFormatTime(h2.content[i2].create_time * 1000) + (h2.content[i2].is_author_view == 1 ? " " + viewGroup.getContext().getString(R.string.not_open_read) : ""), String.valueOf(h2.thread_type)});
            }
        }
        cVar.v.setContent(arrayList);
        if (Pattern.compile("^回复：").matcher(h2.title).find()) {
            cVar.w.setText(h2.title.replaceFirst("回复：", "原贴："));
        } else {
            cVar.w.setText(h2.title);
        }
        OriginalThreadInfo originalThreadInfo = h2.originalThreadInfo;
        if (originalThreadInfo != null && !StringUtils.isNull(originalThreadInfo.f12873b)) {
            cVar.w.setText("分享：" + h2.originalThreadInfo.f12873b);
        }
        cVar.w.setTag(new String[]{String.valueOf(h2.thread_id), null, null, String.valueOf(h2.thread_type)});
        if (h2.thread_type == 33) {
            cVar.w.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(R.drawable.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            cVar.w.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        SkinManager.setBackgroundResource(cVar.w, R.drawable.person_post_line);
        SkinManager.setViewTextColor(cVar.w, R.color.common_color_10039, 1);
        int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(R.dimen.ds20);
        cVar.w.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        cVar.c(this.l);
        cVar.a(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<n> arrayList;
        PersonPostModel personPostModel = this.f58377f;
        if (personPostModel == null || (arrayList = personPostModel.postList) == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        c cVar;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.person_post_item_reply, viewGroup, false);
            cVar = new c(view, this.j);
            view.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
        }
        if (i == 0) {
            cVar.l.setVisibility(0);
        } else {
            cVar.l.setVisibility(8);
        }
        g(i, cVar, viewGroup);
        return view;
    }

    public PersonPostModel.PostInfoList h(int i) {
        return (PersonPostModel.PostInfoList) this.f58377f.postList.get(i);
    }

    public void i(PersonPostModel.c cVar) {
        this.f58376e = cVar;
    }
}
