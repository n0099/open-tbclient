package d.a.p0.g1.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.RelateTopicForumActivity;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
import com.baidu.tieba.hottopic.holder.RelateTopicForumItemHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class j extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<RelateForumItemData> f56327e;

    /* renamed from: f  reason: collision with root package name */
    public String f56328f;

    /* renamed from: g  reason: collision with root package name */
    public RelateTopicForumActivity f56329g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f56330h;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f56331e;

        public a(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56331e = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f56331e.f56329g != null && this.f56331e.f56329g.checkUpIsLogin() && view.getId() == R.id.forum_add_love && (intValue = ((Integer) view.getTag()).intValue()) >= 0) {
                RelateForumItemData relateForumItemData = (RelateForumItemData) this.f56331e.f56327e.get(intValue);
                if (relateForumItemData.forumId != 0) {
                    TiebaStatic.log(new StatisticItem("c10371").param("fid", String.valueOf(relateForumItemData.forumId)).param("obj_type", d.a.p0.g1.c.k.f56438b).param("topic_id", this.f56331e.f56328f));
                }
                if (d.a.c.e.p.k.isForumName(relateForumItemData.forumName)) {
                    this.f56331e.f56329g.likeModel.L(relateForumItemData.forumName, String.valueOf(relateForumItemData.forumId));
                }
            }
        }
    }

    public j(RelateTopicForumActivity relateTopicForumActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {relateTopicForumActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f56327e = new ArrayList<>();
        this.f56330h = new a(this);
        this.f56329g = relateTopicForumActivity;
    }

    public void d(List<RelateForumItemData> list, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, list, str) == null) {
            this.f56327e.clear();
            this.f56327e.addAll(list);
            this.f56328f = str;
            notifyDataSetChanged();
        }
    }

    public void e(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            view.setLayoutParams(layoutParams);
        }
    }

    public final void f(TextView textView, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, textView, z) == null) {
            if (z) {
                textView.setEnabled(false);
                SkinManager.setViewTextColor(textView, R.color.CAM_X0109, 1);
                textView.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
                textView.setBackgroundDrawable(null);
                return;
            }
            SkinManager.setViewTextColor(textView, R.color.CAM_X0101, 1);
            textView.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
            SkinManager.setBackgroundResource(textView, R.drawable.btn_appdownload);
            textView.setEnabled(true);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f56327e.size() : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? this.f56327e.get(i2) : invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        RelateTopicForumItemHolder relateTopicForumItemHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                view = LayoutInflater.from(this.f56329g.getPageContext().getContext()).inflate(R.layout.hot_topic_list_item, (ViewGroup) null);
                relateTopicForumItemHolder = new RelateTopicForumItemHolder(view);
                view.setTag(relateTopicForumItemHolder);
                relateTopicForumItemHolder.f17138h.setOnClickListener(this.f56330h);
            } else {
                relateTopicForumItemHolder = (RelateTopicForumItemHolder) view.getTag();
            }
            relateTopicForumItemHolder.f17138h.setTag(Integer.valueOf(i2));
            ArrayList<RelateForumItemData> arrayList = this.f56327e;
            if (arrayList != null && arrayList.get(i2) != null) {
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                if (relateTopicForumItemHolder.j != skinType) {
                    SkinManager.setViewTextColor(relateTopicForumItemHolder.f17132b, R.color.CAM_X0105, 1);
                    SkinManager.setViewTextColor(relateTopicForumItemHolder.f17135e, R.color.CAM_X0108, 1);
                    SkinManager.setViewTextColor(relateTopicForumItemHolder.f17136f, R.color.CAM_X0108, 1);
                    SkinManager.setViewTextColor(relateTopicForumItemHolder.f17133c, R.color.CAM_X0108, 1);
                    SkinManager.setViewTextColor(relateTopicForumItemHolder.f17134d, R.color.CAM_X0108, 1);
                    SkinManager.setViewTextColor(relateTopicForumItemHolder.f17137g, R.color.CAM_X0109, 1);
                    SkinManager.setBackgroundResource(relateTopicForumItemHolder.f17139i, R.color.CAM_X0204);
                    SkinManager.setBackgroundResource(relateTopicForumItemHolder.f17138h, R.drawable.btn_appdownload);
                    SkinManager.setBackgroundResource(view, R.drawable.list_item_selector);
                    relateTopicForumItemHolder.j = skinType;
                }
                relateTopicForumItemHolder.f17132b.setText(this.f56327e.get(i2).forumName);
                if (!StringUtils.isNULL(this.f56327e.get(i2).forumAvatar)) {
                    relateTopicForumItemHolder.f17131a.M(this.f56327e.get(i2).forumAvatar, 10, false);
                }
                relateTopicForumItemHolder.f17135e.setText(StringHelper.numberUniformFormat(this.f56327e.get(i2).postNum));
                relateTopicForumItemHolder.f17136f.setText(StringHelper.numberUniformFormat(this.f56327e.get(i2).followNum));
                relateTopicForumItemHolder.f17137g.setText(StringHelper.forceLToR(this.f56327e.get(i2).forumAbstract));
                f(relateTopicForumItemHolder.f17138h, this.f56327e.get(i2).isLiked);
                if (i2 == this.f56327e.size() - 1) {
                    e(relateTopicForumItemHolder.f17139i);
                }
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
