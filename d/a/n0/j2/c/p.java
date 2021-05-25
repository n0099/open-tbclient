package d.a.n0.j2.c;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.PersonPolymericActivity;
import com.baidu.tieba.personPolymeric.holder.PersonCommentHolder;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.ArrayList;
import java.util.regex.Pattern;
/* loaded from: classes5.dex */
public class p extends d.a.c.j.e.a<PersonPostModel.PostInfoList, PersonCommentHolder> {
    public String m;
    public TbPageContext<PersonPolymericActivity> n;
    public boolean o;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tbadk.TbPageContext<?> */
    /* JADX WARN: Multi-variable type inference failed */
    public p(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.n = tbPageContext;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // d.a.c.j.e.a
    public /* bridge */ /* synthetic */ View W(int i2, View view, ViewGroup viewGroup, PersonPostModel.PostInfoList postInfoList, PersonCommentHolder personCommentHolder) {
        f0(i2, view, viewGroup, postInfoList, personCommentHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public PersonCommentHolder P(ViewGroup viewGroup) {
        return new PersonCommentHolder(LayoutInflater.from(this.n.getPageActivity()).inflate(R.layout.person_polymeric_item_reply, viewGroup, false), this.n, this.o);
    }

    public View f0(int i2, View view, ViewGroup viewGroup, PersonPostModel.PostInfoList postInfoList, PersonCommentHolder personCommentHolder) {
        if (postInfoList != null && personCommentHolder != null) {
            if (this.m == null) {
                this.m = postInfoList.user_portrait;
            }
            personCommentHolder.d(postInfoList, false, this.m);
            ArrayList<String[]> arrayList = new ArrayList<>();
            int length = postInfoList.content.length;
            for (int i3 = 0; i3 < length; i3++) {
                if (postInfoList.content[i3].post_content.length != 0) {
                    StringBuffer stringBuffer = new StringBuffer();
                    if (!postInfoList.content[i3].post_content[0].text.startsWith("回复 ")) {
                        stringBuffer.append("回复：");
                    }
                    int length2 = postInfoList.content[i3].post_content.length;
                    for (int i4 = 0; i4 < length2; i4++) {
                        stringBuffer.append(postInfoList.content[i3].post_content[i4].text);
                    }
                    arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(postInfoList.thread_id), String.valueOf(postInfoList.content[i3].post_id), String.valueOf(postInfoList.content[i3].post_type), StringHelper.getFormatTime(postInfoList.content[i3].create_time * 1000), String.valueOf(postInfoList.thread_type)});
                }
            }
            personCommentHolder.f19850e.setContent(arrayList);
            if (Pattern.compile("^回复：").matcher(postInfoList.title).find()) {
                personCommentHolder.f19851f.setText(postInfoList.title.replaceFirst("回复：", "原贴："));
            } else {
                personCommentHolder.f19851f.setText(postInfoList.title);
            }
            personCommentHolder.f19851f.setTag(new String[]{String.valueOf(postInfoList.thread_id), null, null, String.valueOf(postInfoList.thread_type)});
            if (postInfoList.thread_type == 33) {
                personCommentHolder.f19851f.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(R.drawable.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                personCommentHolder.f19851f.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            SkinManager.setBackgroundResource(personCommentHolder.f19851f, R.drawable.person_post_line);
            SkinManager.setViewTextColor(personCommentHolder.f19851f, R.color.common_color_10039, 1);
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds20);
            personCommentHolder.f19851f.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
            personCommentHolder.b(TbadkCoreApplication.getInst().getSkinType());
        }
        return view;
    }

    public void g0(boolean z) {
        this.o = z;
    }
}
