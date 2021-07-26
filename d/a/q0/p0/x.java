package d.a.q0.p0;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class x extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.p0.f.a> f61934e;

    /* renamed from: f  reason: collision with root package name */
    public String f61935f;

    /* renamed from: g  reason: collision with root package name */
    public Context f61936g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.p0.c0.b f61937h;

    /* renamed from: i  reason: collision with root package name */
    public int f61938i;
    public int j;

    /* loaded from: classes8.dex */
    public class a implements d.a.p0.b0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f61939e;

        public a(x xVar, ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xVar, viewGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61939e = viewGroup;
        }

        @Override // d.a.p0.b0.b
        public void a(d.a.d.k.d.a aVar, String str, boolean z) {
            HeadImageView headImageView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, aVar, str, z) == null) || (headImageView = (HeadImageView) this.f61939e.findViewWithTag(str)) == null || aVar == null) {
                return;
            }
            headImageView.invalidate();
        }
    }

    /* loaded from: classes8.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public HeadImageView f61940a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f61941b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f61942c;

        public b(x xVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(x xVar, a aVar) {
            this(xVar);
        }
    }

    public x(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f61936g = context;
        this.f61937h = new d.a.p0.c0.b();
        this.j = (int) this.f61936g.getResources().getDimension(R.dimen.ds120);
        this.f61938i = d.a.d.e.p.l.k(this.f61936g) / 2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public d.a.p0.f.a getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            List<d.a.p0.f.a> list = this.f61934e;
            if (list == null || i2 < 0 || i2 >= list.size()) {
                return null;
            }
            return this.f61934e.get(i2);
        }
        return (d.a.p0.f.a) invokeI.objValue;
    }

    public void b(List<d.a.p0.f.a> list, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, str) == null) {
            this.f61934e = list;
            this.f61935f = str;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<d.a.p0.f.a> list = this.f61934e;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i2, view, viewGroup)) == null) {
            if (view != null) {
                bVar = (b) view.getTag();
            } else {
                view = LayoutInflater.from(this.f61936g).inflate(R.layout.collect_album_list_item, viewGroup, false);
                bVar = new b(this, null);
                bVar.f61940a = (HeadImageView) view.findViewById(R.id.item_head);
                bVar.f61941b = (TextView) view.findViewById(R.id.item_name);
                ImageView imageView = (ImageView) view.findViewById(R.id.item_arrow);
                bVar.f61942c = imageView;
                SkinManager.setImageResource(imageView, R.drawable.icon_site_ok);
                view.setTag(bVar);
            }
            bVar.f61940a.setTag(null);
            bVar.f61940a.setDefaultResource(R.drawable.pic_image_h_not);
            bVar.f61940a.M(null, 12, false);
            bVar.f61940a.invalidate();
            d.a.p0.f.a item = getItem(i2);
            if (item != null) {
                if (!TextUtils.isEmpty(item.g())) {
                    item.g();
                    String s = d.a.d.e.p.l.s(bVar.f61941b.getPaint(), item.g(), this.f61938i);
                    bVar.f61941b.setText(s + "(" + item.c() + SmallTailInfo.EMOTION_SUFFIX);
                } else {
                    bVar.f61941b.setText("");
                }
                String b2 = item.b();
                if (!TextUtils.isEmpty(b2) && b2.equals(this.f61935f)) {
                    bVar.f61942c.setVisibility(0);
                } else {
                    bVar.f61942c.setVisibility(8);
                }
                ImageFileInfo e2 = item.e();
                if (e2 != null) {
                    e2.clearPageActions();
                    int i3 = this.j;
                    e2.addPageAction(d.a.p0.c0.g.d.g(i3, i3));
                    d.a.d.k.d.a c2 = this.f61937h.c(e2, false);
                    bVar.f61940a.setTag(e2.toCachedKey(false));
                    if (c2 != null) {
                        bVar.f61940a.invalidate();
                    } else {
                        this.f61937h.e(e2, new a(this, viewGroup), false, false);
                    }
                }
            } else {
                bVar.f61941b.setText("");
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
