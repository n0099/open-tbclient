package d.a.s0.l2;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.personExtra.PersonBarActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class c extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public PersonBarActivity f63231e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.s0.l2.b f63232f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<ForumData> f63233g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f63234h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f63235i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public View.OnClickListener n;
    public String o;

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public BarImageView f63236a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f63237b;

        /* renamed from: c  reason: collision with root package name */
        public StringBuffer f63238c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f63239d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f63240e;

        /* renamed from: f  reason: collision with root package name */
        public ImageView f63241f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f63242g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f63243h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f63244i;
        public Button j;
        public ImageView k;
        public ImageView l;
        public ImageView m;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(c cVar, a aVar) {
            this(cVar);
        }
    }

    public c(PersonBarActivity personBarActivity, d.a.s0.l2.b bVar, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {personBarActivity, bVar, Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f63232f = null;
        this.f63233g = null;
        this.f63234h = false;
        this.f63235i = null;
        this.j = false;
        this.k = true;
        this.l = false;
        this.m = true;
        this.f63231e = personBarActivity;
        this.f63232f = bVar;
        this.k = z;
        this.l = z2;
        this.m = TbadkCoreApplication.getInst().appResponseToCmd(2002006);
    }

    public final void a(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            this.f63231e.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.f63231e.getLayoutMode().j(view);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.j = false;
            ArrayList<ForumData> arrayList = this.f63233g;
            if (arrayList == null || arrayList.size() == 0) {
                this.j = true;
            }
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f63234h : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.j : invokeV.booleanValue;
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.f63235i = onClickListener;
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f63234h = z;
            notifyDataSetChanged();
        }
    }

    public void g(ArrayList<ForumData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, arrayList) == null) {
            this.f63233g = arrayList;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.j) {
                return 1;
            }
            ArrayList<ForumData> arrayList = this.f63233g;
            if (arrayList != null) {
                return arrayList.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            ArrayList<ForumData> arrayList = this.f63233g;
            if (arrayList == null || i2 < 0 || i2 >= arrayList.size()) {
                return null;
            }
            return this.f63233g.get(i2);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        b bVar;
        ForumData forumData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048586, this, i2, view, viewGroup)) == null) {
            try {
                if (view == null) {
                    view = LayoutInflater.from(this.f63231e.getPageContext().getContext()).inflate(R.layout.edit_bar_item, (ViewGroup) null);
                    bVar = new b(this, null);
                    BarImageView barImageView = (BarImageView) view.findViewById(R.id.forum_avatar);
                    bVar.f63236a = barImageView;
                    barImageView.setGifIconSupport(false);
                    bVar.f63236a.setRadius(l.g(this.f63231e, R.dimen.tbds10));
                    bVar.f63236a.setConrers(15);
                    bVar.f63236a.setPlaceHolder(2);
                    bVar.f63237b = (TextView) view.findViewById(R.id.name);
                    bVar.f63238c = new StringBuffer(10);
                    bVar.f63239d = (TextView) view.findViewById(R.id.degree);
                    bVar.f63240e = (TextView) view.findViewById(R.id.degree_text);
                    bVar.f63244i = (TextView) view.findViewById(R.id.experience);
                    bVar.f63242g = (TextView) view.findViewById(R.id.experience_title);
                    bVar.j = (Button) view.findViewById(R.id.item_delete);
                    bVar.f63241f = (ImageView) view.findViewById(R.id.degree_text_ta);
                    bVar.f63243h = (TextView) view.findViewById(R.id.intro_ta);
                    bVar.k = (ImageView) view.findViewById(R.id.item_talk);
                    ImageView imageView = (ImageView) view.findViewById(R.id.diver_buttom_px);
                    bVar.l = imageView;
                    imageView.setVisibility(0);
                    bVar.m = (ImageView) view.findViewById(R.id.item_selected);
                    view.setTag(bVar);
                } else {
                    bVar = (b) view.getTag();
                }
                if (this.j) {
                    bVar.f63239d.setVisibility(8);
                    bVar.j.setVisibility(8);
                    bVar.f63237b.setVisibility(8);
                    bVar.f63236a.setVisibility(8);
                    bVar.f63240e.setVisibility(8);
                    bVar.f63244i.setVisibility(8);
                    bVar.f63242g.setVisibility(8);
                    bVar.f63241f.setVisibility(8);
                    bVar.f63243h.setVisibility(8);
                    bVar.k.setVisibility(8);
                    bVar.l.setVisibility(8);
                } else {
                    bVar.f63237b.setVisibility(0);
                    bVar.f63236a.setVisibility(0);
                    if (this.k) {
                        bVar.f63239d.setVisibility(8);
                        bVar.f63240e.setVisibility(8);
                        bVar.f63244i.setVisibility(0);
                        bVar.f63242g.setVisibility(0);
                        bVar.f63241f.setVisibility(0);
                        bVar.f63243h.setVisibility(8);
                        bVar.l.setVisibility(0);
                    } else {
                        bVar.f63239d.setVisibility(8);
                        bVar.f63240e.setVisibility(8);
                        bVar.f63244i.setVisibility(8);
                        bVar.f63242g.setVisibility(8);
                        bVar.f63241f.setVisibility(0);
                        bVar.f63243h.setVisibility(0);
                        bVar.l.setVisibility(0);
                    }
                }
                if (this.f63233g != null && i2 >= 0 && i2 < this.f63233g.size() && (forumData = this.f63233g.get(i2)) != null) {
                    String image_url = forumData.getImage_url();
                    bVar.f63236a.setTag(image_url);
                    bVar.f63236a.setImageDrawable(null);
                    bVar.f63236a.M(image_url, 10, false);
                    bVar.f63238c.delete(0, bVar.f63238c.length());
                    bVar.f63238c.append(forumData.getName());
                    bVar.f63238c.append(this.f63231e.getPageContext().getString(R.string.forum));
                    bVar.f63237b.setText(bVar.f63238c);
                    if (this.k) {
                        SkinManager.setImageResource(bVar.f63241f, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                        bVar.f63244i.setText(String.format(this.f63231e.getPageContext().getString(R.string.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                        bVar.j.setOnClickListener(this.f63235i);
                        bVar.j.setTag(Integer.valueOf(i2));
                        if (i2 < this.f63232f.k()) {
                            bVar.f63237b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_v), (Drawable) null);
                            if (!this.l && this.m) {
                                bVar.k.setVisibility(0);
                                bVar.k.setTag(Integer.valueOf(i2));
                            }
                        } else {
                            bVar.f63237b.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                            bVar.k.setVisibility(8);
                        }
                        bVar.k.setOnClickListener(this.n);
                        bVar.m.setVisibility(8);
                        if (this.l && this.f63231e.getRequestCode() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.o)) {
                            bVar.m.setVisibility(0);
                        }
                    } else {
                        if ((this.f63231e.getCurrentPageType() == 0 && i2 < this.f63232f.k()) || (this.f63231e.getCurrentPageType() == 1 && i2 < this.f63232f.g())) {
                            bVar.f63237b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_v), (Drawable) null);
                        } else {
                            bVar.f63237b.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        }
                        if (this.f63231e.getCurrentPageType() == 1) {
                            bVar.f63241f.setVisibility(8);
                        }
                        bVar.k.setVisibility(8);
                        SkinManager.setImageResource(bVar.f63241f, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                        bVar.f63243h.setText(forumData.getSlogan());
                    }
                    if (this.f63234h) {
                        bVar.j.setVisibility(0);
                        bVar.k.setVisibility(8);
                    } else {
                        bVar.j.setVisibility(8);
                        if (i2 < this.f63232f.k() && this.k && !this.l && this.m) {
                            bVar.k.setVisibility(0);
                        } else {
                            bVar.k.setVisibility(8);
                        }
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            a(view);
            return view;
        }
        return (View) invokeILL.objValue;
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.o = str;
        }
    }

    public void i(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onClickListener) == null) {
            this.n = onClickListener;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
            if (this.j) {
                return false;
            }
            return super.isEnabled(i2);
        }
        return invokeI.booleanValue;
    }
}
