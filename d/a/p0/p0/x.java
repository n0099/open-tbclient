package d.a.p0.p0;

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
    public List<d.a.o0.e.a> f61320e;

    /* renamed from: f  reason: collision with root package name */
    public String f61321f;

    /* renamed from: g  reason: collision with root package name */
    public Context f61322g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.o0.b0.b f61323h;

    /* renamed from: i  reason: collision with root package name */
    public int f61324i;
    public int j;

    /* loaded from: classes8.dex */
    public class a implements d.a.o0.a0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f61325e;

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
            this.f61325e = viewGroup;
        }

        @Override // d.a.o0.a0.b
        public void a(d.a.c.k.d.a aVar, String str, boolean z) {
            HeadImageView headImageView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, aVar, str, z) == null) || (headImageView = (HeadImageView) this.f61325e.findViewWithTag(str)) == null || aVar == null) {
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
        public HeadImageView f61326a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f61327b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f61328c;

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
        this.f61322g = context;
        this.f61323h = new d.a.o0.b0.b();
        this.j = (int) this.f61322g.getResources().getDimension(R.dimen.ds120);
        this.f61324i = d.a.c.e.p.l.k(this.f61322g) / 2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public d.a.o0.e.a getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            List<d.a.o0.e.a> list = this.f61320e;
            if (list == null || i2 < 0 || i2 >= list.size()) {
                return null;
            }
            return this.f61320e.get(i2);
        }
        return (d.a.o0.e.a) invokeI.objValue;
    }

    public void b(List<d.a.o0.e.a> list, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, str) == null) {
            this.f61320e = list;
            this.f61321f = str;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<d.a.o0.e.a> list = this.f61320e;
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
                view = LayoutInflater.from(this.f61322g).inflate(R.layout.collect_album_list_item, viewGroup, false);
                bVar = new b(this, null);
                bVar.f61326a = (HeadImageView) view.findViewById(R.id.item_head);
                bVar.f61327b = (TextView) view.findViewById(R.id.item_name);
                ImageView imageView = (ImageView) view.findViewById(R.id.item_arrow);
                bVar.f61328c = imageView;
                SkinManager.setImageResource(imageView, R.drawable.icon_site_ok);
                view.setTag(bVar);
            }
            bVar.f61326a.setTag(null);
            bVar.f61326a.setDefaultResource(R.drawable.pic_image_h_not);
            bVar.f61326a.M(null, 12, false);
            bVar.f61326a.invalidate();
            d.a.o0.e.a item = getItem(i2);
            if (item != null) {
                if (!TextUtils.isEmpty(item.g())) {
                    item.g();
                    String s = d.a.c.e.p.l.s(bVar.f61327b.getPaint(), item.g(), this.f61324i);
                    bVar.f61327b.setText(s + "(" + item.c() + SmallTailInfo.EMOTION_SUFFIX);
                } else {
                    bVar.f61327b.setText("");
                }
                String b2 = item.b();
                if (!TextUtils.isEmpty(b2) && b2.equals(this.f61321f)) {
                    bVar.f61328c.setVisibility(0);
                } else {
                    bVar.f61328c.setVisibility(8);
                }
                ImageFileInfo e2 = item.e();
                if (e2 != null) {
                    e2.clearPageActions();
                    int i3 = this.j;
                    e2.addPageAction(d.a.o0.b0.g.d.g(i3, i3));
                    d.a.c.k.d.a c2 = this.f61323h.c(e2, false);
                    bVar.f61326a.setTag(e2.toCachedKey(false));
                    if (c2 != null) {
                        bVar.f61326a.invalidate();
                    } else {
                        this.f61323h.e(e2, new a(this, viewGroup), false, false);
                    }
                }
            } else {
                bVar.f61327b.setText("");
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
