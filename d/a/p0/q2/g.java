package d.a.p0.q2;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.k.e.n;
import d.a.p0.q2.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes8.dex */
public class g extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public PersonPostModel.c f61725e;

    /* renamed from: f  reason: collision with root package name */
    public PersonPostModel f61726f;

    /* renamed from: g  reason: collision with root package name */
    public final String f61727g;

    /* renamed from: h  reason: collision with root package name */
    public BdUniqueId f61728h;

    /* renamed from: i  reason: collision with root package name */
    public String f61729i;
    public TbPageContext<BaseFragmentActivity> j;
    public final PersonPostModel.c k;
    public final a.InterfaceC1607a l;

    /* loaded from: classes8.dex */
    public class a implements PersonPostModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f61730e;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61730e = gVar;
        }

        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.c
        public void L(PersonPostModel personPostModel, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, personPostModel, z) == null) {
                if (z) {
                    this.f61730e.f61726f = personPostModel;
                    Iterator<n> it = this.f61730e.f61726f.postList.iterator();
                    while (it.hasNext()) {
                        n next = it.next();
                        if (next != null && !(next instanceof PersonPostModel.PostInfoList)) {
                            it.remove();
                        }
                    }
                } else if (this.f61730e.f61726f != null) {
                    for (int i2 = 0; i2 < personPostModel.postList.size(); i2++) {
                        if (personPostModel.postList.get(i2) instanceof PersonPostModel.PostInfoList) {
                            this.f61730e.f61726f.postList.add(personPostModel.postList.get(i2));
                        }
                    }
                }
                if (this.f61730e.f61725e != null) {
                    this.f61730e.f61725e.L(personPostModel, z);
                }
                this.f61730e.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements a.InterfaceC1607a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f61731a;

        public b(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61731a = gVar;
        }

        @Override // d.a.p0.q2.a.InterfaceC1607a
        public void a(View view) {
            String[] strArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                int id = view.getId();
                if (id == R.id.portrait) {
                    ((BaseFragmentActivity) this.f61731a.j.getOrignalPage()).finish();
                } else if (id == R.id.username) {
                    ((BaseFragmentActivity) this.f61731a.j.getOrignalPage()).finish();
                } else if ((id == R.id.item_header || id == R.id.original_post_title || id == R.id.item_footer || id == R.id.reply_count) && (strArr = (String[]) view.getTag()) != null) {
                    if (!"0".equals(strArr[2]) && strArr[1] != null) {
                        SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(this.f61731a.j.getPageActivity()).createSubPbActivityConfig(strArr[0], strArr[1], "person_post_reply", false);
                        createSubPbActivityConfig.setKeyPageStartFrom(4);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
                        return;
                    }
                    PbActivityConfig createNormalCfg = new PbActivityConfig(this.f61731a.j.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_page");
                    createNormalCfg.setStartFrom(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                }
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    /* loaded from: classes8.dex */
    public static class c extends d.a.p0.q2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ReplyLinearLayout v;
        public TextView w;
        public View x;
        public View y;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(View view, TbPageContext<BaseFragmentActivity> tbPageContext) {
            super(view, tbPageContext);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((View) objArr2[0], (TbPageContext) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.v = (ReplyLinearLayout) view.findViewById(R.id.content_container);
            this.w = (TextView) view.findViewById(R.id.original_post_title);
            this.x = view.findViewById(R.id.reply_top_line);
            this.y = view.findViewById(R.id.reply_bottom_line);
            this.w.setOnClickListener(this);
        }

        @Override // d.a.p0.q2.a
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                super.a(i2);
                SkinManager.setBackgroundResource(this.w, R.color.CAM_X0205);
                SkinManager.setViewTextColor(this.w, R.color.CAM_X0105, 1);
                SkinManager.setBackgroundResource(this.x, R.color.CAM_X0204);
                SkinManager.setBackgroundResource(this.y, R.color.CAM_X0204);
            }
        }
    }

    public g(TbPageContext<BaseFragmentActivity> tbPageContext, String str, String str2, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, str, str2, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = new a(this);
        this.l = new b(this);
        this.j = tbPageContext;
        this.f61727g = str;
        this.f61728h = bdUniqueId;
    }

    public void e() {
        PersonPostModel personPostModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (personPostModel = this.f61726f) == null) {
            return;
        }
        personPostModel.cancelLoadData();
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (this.f61726f == null) {
                PersonPostModel personPostModel = new PersonPostModel(this.j, this.f61728h, null, true, PersonPostModel.FROM_PERSON_POST);
                this.f61726f = personPostModel;
                personPostModel.setUniqueId(this.f61728h);
            }
            this.f61726f.fetchPost(this.j, this.k, z, this.f61727g, false, true, false, null);
        }
    }

    public final void g(int i2, c cVar, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, cVar, viewGroup) == null) {
            PersonPostModel.PostInfoList h2 = h(i2);
            if (this.f61729i == null) {
                this.f61729i = h2.user_portrait;
            }
            cVar.d(h2, false, this.f61729i);
            ArrayList<String[]> arrayList = new ArrayList<>();
            int length = h2.content.length;
            for (int i3 = 0; i3 < length; i3++) {
                if (h2.content[i3].post_content.length != 0) {
                    StringBuffer stringBuffer = new StringBuffer();
                    if (!h2.content[i3].post_content[0].text.startsWith("回复 ")) {
                        stringBuffer.append("回复：");
                    }
                    int length2 = h2.content[i3].post_content.length;
                    for (int i4 = 0; i4 < length2; i4++) {
                        stringBuffer.append(h2.content[i3].post_content[i4].text);
                    }
                    arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(h2.thread_id), String.valueOf(h2.content[i3].post_id), String.valueOf(h2.content[i3].post_type), StringHelper.getFormatTime(h2.content[i3].create_time * 1000) + (h2.content[i3].is_author_view == 1 ? " " + viewGroup.getContext().getString(R.string.not_open_read) : ""), String.valueOf(h2.thread_type)});
                }
            }
            cVar.v.setContent(arrayList);
            if (Pattern.compile("^回复：").matcher(h2.title).find()) {
                cVar.w.setText(h2.title.replaceFirst("回复：", "原贴："));
            } else {
                cVar.w.setText(h2.title);
            }
            OriginalThreadInfo originalThreadInfo = h2.originalThreadInfo;
            if (originalThreadInfo != null && !StringUtils.isNull(originalThreadInfo.f12248b)) {
                cVar.w.setText("分享：" + h2.originalThreadInfo.f12248b);
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
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        ArrayList<n> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            PersonPostModel personPostModel = this.f61726f;
            if (personPostModel == null || (arrayList = personPostModel.postList) == null) {
                return 0;
            }
            return arrayList.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            return null;
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.person_post_item_reply, viewGroup, false);
                cVar = new c(view, this.j);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            if (i2 == 0) {
                cVar.l.setVisibility(0);
            } else {
                cVar.l.setVisibility(8);
            }
            g(i2, cVar, viewGroup);
            return view;
        }
        return (View) invokeILL.objValue;
    }

    public PersonPostModel.PostInfoList h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) ? (PersonPostModel.PostInfoList) this.f61726f.postList.get(i2) : (PersonPostModel.PostInfoList) invokeI.objValue;
    }

    public void i(PersonPostModel.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) {
            this.f61725e = cVar;
        }
    }
}
