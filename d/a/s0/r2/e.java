package d.a.s0.r2;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.r2.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class e extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f65120e;

    /* renamed from: f  reason: collision with root package name */
    public final List<b.a> f65121f;

    /* renamed from: g  reason: collision with root package name */
    public int f65122g;

    /* renamed from: h  reason: collision with root package name */
    public String f65123h;

    /* renamed from: i  reason: collision with root package name */
    public String f65124i;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a f65125e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f65126f;

        public a(e eVar, b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65126f = eVar;
            this.f65125e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f65126f.f65120e == null) {
                return;
            }
            this.f65126f.g(this.f65125e);
            if (this.f65125e.f65092g == 1) {
                SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(this.f65126f.f65120e.getPageActivity()).createSubPbActivityConfig(this.f65125e.f65091f + "", this.f65125e.f65086a + "", "search_post", true);
                createSubPbActivityConfig.setKeyPageStartFrom(8);
                this.f65126f.f65120e.sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
                return;
            }
            PbActivityConfig createNormalCfg = new PbActivityConfig(this.f65126f.f65120e.getPageActivity()).createNormalCfg(this.f65125e.f65091f + "", this.f65125e.f65086a + "", "search_post");
            createNormalCfg.setStartFrom(8);
            createNormalCfg.setSortType(0);
            this.f65126f.f65120e.sendMessage(new CustomMessage(2004001, createNormalCfg));
        }
    }

    /* loaded from: classes9.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f65127a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f65128b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f65129c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f65130d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f65131e;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-628125896, "Ld/a/s0/r2/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-628125896, "Ld/a/s0/r2/e;");
                return;
            }
        }
        TbadkCoreApplication.getInst().getListItemRule().c();
    }

    public e(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f65122g = -1;
        this.f65120e = tbPageContext;
        this.f65121f = new ArrayList();
    }

    public void c(List<b.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            this.f65121f.clear();
            this.f65121f.addAll(list);
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f65124i = str;
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f65123h = str;
        }
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f65122g = i2;
        }
    }

    public final void g(b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            StatisticItem param = new StatisticItem("c12405").param("fname", aVar.f65090e).param("uid", TbadkCoreApplication.getCurrentAccount());
            int i2 = this.f65122g;
            if (i2 > 0) {
                param.param("tab_id", i2);
            }
            if (aVar != null) {
                if (aVar.f65092g != 1 && aVar.f65093h != 1) {
                    param.param("tid", aVar.f65091f);
                } else {
                    param.param("pid", aVar.f65086a);
                }
                param.param("fid", this.f65124i);
                param.param("query", this.f65123h);
            }
            TiebaStatic.log(param);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            List<b.a> list = this.f65121f;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            List<b.a> list = this.f65121f;
            if (list == null || list.isEmpty() || i2 < 0 || i2 >= this.f65121f.size()) {
                return null;
            }
            return this.f65121f.get(i2);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                view = LayoutInflater.from(this.f65120e.getPageActivity()).inflate(R.layout.post_search_list_item, (ViewGroup) null);
                b bVar = new b(null);
                bVar.f65127a = (TextView) view.findViewById(R.id.title_text);
                bVar.f65128b = (TextView) view.findViewById(R.id.content_text);
                bVar.f65129c = (TextView) view.findViewById(R.id.label_text);
                bVar.f65130d = (TextView) view.findViewById(R.id.user_name);
                bVar.f65131e = (TextView) view.findViewById(R.id.time_text);
                view.setTag(bVar);
            }
            b bVar2 = (b) view.getTag();
            b.a aVar = this.f65121f.get(i2);
            if (aVar == null) {
                return view;
            }
            String str = TbadkCoreApplication.getInst().getSkinType() == 1 ? "#99260f" : "#e53917";
            bVar2.f65127a.setText(Html.fromHtml(StringHelper.getHighLightString(aVar.f65087b, str)));
            bVar2.f65128b.setText(Html.fromHtml(StringHelper.getHighLightString(aVar.f65089d, str)));
            bVar2.f65130d.setText(aVar.f65094i);
            bVar2.f65131e.setText(StringHelper.getFormatTime(aVar.f65088c));
            bVar2.f65129c.setVisibility(0);
            if (aVar.f65092g == 1) {
                bVar2.f65129c.setText(R.string.floor_text);
            } else if (aVar.f65093h == 1) {
                bVar2.f65129c.setText(R.string.reply_post);
            } else {
                bVar2.f65129c.setVisibility(8);
            }
            view.setOnClickListener(new a(this, aVar));
            SkinManager.setBackgroundColor(view, R.color.CAM_X0201);
            d.a.r0.s0.a.a(this.f65120e, view);
            h(aVar);
            return view;
        }
        return (View) invokeILL.objValue;
    }

    public final void h(b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) {
            StatisticItem param = new StatisticItem("c14171").param("fname", aVar.f65090e).param("uid", TbadkCoreApplication.getCurrentAccount());
            int i2 = this.f65122g;
            if (i2 > 0) {
                param.param("tab_id", i2);
            }
            if (aVar != null) {
                if (aVar.f65092g != 1 && aVar.f65093h != 1) {
                    param.param("tid", aVar.f65091f);
                } else {
                    param.param("pid", aVar.f65086a);
                }
                param.param("fid", this.f65124i);
                param.param("query", this.f65123h);
            }
            TiebaStatic.log(param);
        }
    }
}
