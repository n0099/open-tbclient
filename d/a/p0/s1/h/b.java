package d.a.p0.s1.h;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f62142e;

    /* renamed from: f  reason: collision with root package name */
    public List<String> f62143f;

    /* renamed from: g  reason: collision with root package name */
    public Context f62144g;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    public b(Context context, ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, arrayList};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f62144g = context;
        this.f62143f = arrayList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public String getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            int count = getCount();
            if (count <= 0 || i2 >= count) {
                return null;
            }
            return this.f62143f.get(i2);
        }
        return (String) invokeI.objValue;
    }

    public void b(TextView textView, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textView, str) == null) || textView == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.f62142e)) {
            return;
        }
        String lowerCase = str.toLowerCase();
        String lowerCase2 = this.f62142e.toLowerCase();
        if (!lowerCase.contains(lowerCase2)) {
            textView.setText(str);
            return;
        }
        int indexOf = lowerCase.indexOf(lowerCase2);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0301));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.f62142e.length() + indexOf, 33);
        textView.setText(spannableStringBuilder);
    }

    public void c(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f62143f = list;
            if (list != null) {
                notifyDataSetChanged();
            }
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        this.f62142e = str.trim();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            List<String> list = this.f62143f;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        C1631b c1631b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                view = LayoutInflater.from(this.f62144g).inflate(R.layout.search_suggest_item, (ViewGroup) null);
                c1631b = new C1631b(this, null);
                c1631b.f62146b = view.findViewById(R.id.rootview);
                c1631b.f62147c = (TextView) view.findViewById(R.id.searchSuggestTitle);
                c1631b.f62148d = view.findViewById(R.id.searchItemSep);
                view.setTag(c1631b);
            } else {
                c1631b = (C1631b) view.getTag();
            }
            String item = getItem(i2);
            if (StringUtils.isNull(item)) {
                return view;
            }
            b(c1631b.f62147c, item);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType != c1631b.f62145a) {
                c1631b.f62145a = skinType;
                SkinManager.setBackgroundResource(c1631b.f62146b, R.drawable.addresslist_item_bg);
                SkinManager.setViewTextColor(c1631b.f62147c, R.color.CAM_X0105);
                SkinManager.setBackgroundColor(c1631b.f62148d, R.color.CAM_X0204);
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }

    /* renamed from: d.a.p0.s1.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1631b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f62145a;

        /* renamed from: b  reason: collision with root package name */
        public View f62146b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f62147c;

        /* renamed from: d  reason: collision with root package name */
        public View f62148d;

        public C1631b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62145a = 3;
        }

        public /* synthetic */ C1631b(b bVar, a aVar) {
            this(bVar);
        }
    }
}
