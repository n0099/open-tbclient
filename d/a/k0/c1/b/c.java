package d.a.k0.c1.b;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f52355a;

    /* renamed from: b  reason: collision with root package name */
    public OvalActionButton f52356b;

    /* renamed from: c  reason: collision with root package name */
    public String f52357c;

    /* renamed from: d  reason: collision with root package name */
    public String f52358d;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.b();
        }
    }

    public c(OvalActionButton ovalActionButton, TbPageContext<?> tbPageContext) {
        this.f52355a = tbPageContext;
        this.f52356b = ovalActionButton;
        ovalActionButton.setIsCircle(true);
        this.f52356b.setHasShadow(false);
        this.f52356b.setOnClickListener(new a());
    }

    public final void b() {
        if (WriteActivityConfig.isAsyncWriting() || this.f52357c == null) {
            return;
        }
        WriteActivityConfig.newInstance(this.f52355a.getPageActivity()).setType(9).setForumId("0").setTopicId(String.valueOf(this.f52357c)).setFrom("topic_detail").setCallFrom("1").setTitle(StringUtils.isNull(this.f52358d) ? null : String.format(TbadkCoreApplication.getInst().getString(R.string.hot_topic_detail_write_name), this.f52358d)).send();
    }

    public void c(String str) {
        this.f52358d = str;
    }

    public void d(String str) {
        this.f52357c = str;
    }
}
