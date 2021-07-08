package d.a.p0.v3.j;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.record.VideoEffectLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class d extends BaseAdapter implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<e> f65588e;

    /* renamed from: f  reason: collision with root package name */
    public String f65589f;

    /* renamed from: g  reason: collision with root package name */
    public int f65590g;

    /* renamed from: h  reason: collision with root package name */
    public VideoEffectLayout.h f65591h;

    /* loaded from: classes8.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f65592a;

        /* renamed from: b  reason: collision with root package name */
        public ProgressBar f65593b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f65594c;

        /* renamed from: d  reason: collision with root package name */
        public int f65595d;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f65590g = -1;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public e getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            List<e> list = this.f65588e;
            if (list != null && i2 >= 0 && i2 < list.size()) {
                return this.f65588e.get(i2);
            }
            return null;
        }
        return (e) invokeI.objValue;
    }

    public final void b(a aVar, View view, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, view, viewGroup) == null) {
            TbImageView tbImageView = (TbImageView) view.findViewById(R.id.iv_effect);
            aVar.f65592a = tbImageView;
            tbImageView.setIsRound(true);
            aVar.f65592a.setDrawerType(1);
            aVar.f65592a.setDefaultBgResource(R.color.transparent);
            aVar.f65592a.setBorderWidth(d.a.c.e.p.l.g(viewGroup.getContext(), R.dimen.ds4));
            aVar.f65592a.setConrers(15);
            aVar.f65592a.setBorderColor(SkinManager.getColor(R.color.CAM_X0302));
            aVar.f65594c = (TextView) view.findViewById(R.id.tv_name);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && getItem(0) != null && getItem(0).c() == 3) {
            this.f65590g = 0;
            this.f65589f = TbadkCoreApplication.getInst().getString(R.string.music_normal);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && getItem(0) != null && getItem(0).c() == 3) {
            this.f65590g = 1;
            this.f65589f = TbadkCoreApplication.getInst().getString(R.string.music_cloud);
            notifyDataSetChanged();
        }
    }

    public void e(List<e> list, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, list, str) == null) {
            this.f65588e = list;
            this.f65589f = str;
        }
    }

    public void f(VideoEffectLayout.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, hVar) == null) {
            this.f65591h = hVar;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            List<e> list = this.f65588e;
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
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            e item = getItem(i2);
            if (item == null) {
                return 0;
            }
            int c2 = item.c();
            if (c2 != 1) {
                return c2 != 3 ? 0 : 1;
            }
            return 2;
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        a aVar;
        e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048586, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                aVar = new a(this);
                int itemViewType = getItemViewType(i2);
                if (itemViewType == 0) {
                    view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_effect, (ViewGroup) null);
                    b(aVar, view, viewGroup);
                    ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.iv_loading);
                    aVar.f65593b = progressBar;
                    progressBar.setVisibility(4);
                    SkinManager.setViewTextColor(aVar.f65594c, R.color.CAM_X0101);
                } else if (itemViewType == 1) {
                    view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_effect, (ViewGroup) null);
                    b(aVar, view, viewGroup);
                    aVar.f65593b = (ProgressBar) view.findViewById(R.id.iv_loading);
                    aVar.f65592a.setDefaultResource(R.drawable.bg_video_cloudmusic);
                    SkinManager.setViewTextColor(aVar.f65594c, R.color.CAM_X0101);
                } else if (itemViewType == 2) {
                    view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_beauty, (ViewGroup) null);
                    b(aVar, view, viewGroup);
                    SkinManager.setViewTextColor(aVar.f65594c, R.color.CAM_X0101);
                }
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            List<e> list = this.f65588e;
            if (list != null && i2 >= 0 && i2 <= list.size() - 1 && (eVar = this.f65588e.get(i2)) != null) {
                int itemViewType2 = getItemViewType(i2);
                if (itemViewType2 == 0) {
                    aVar.f65592a.M(String.valueOf(eVar.a()), 24, false);
                    if (!TextUtils.isEmpty(eVar.b()) && eVar.b().equals(this.f65589f)) {
                        aVar.f65592a.setDrawBorder(true);
                    } else {
                        aVar.f65592a.setDrawBorder(false);
                    }
                } else if (itemViewType2 == 1) {
                    MusicData musicData = (MusicData) eVar.d();
                    if (musicData.editMusicType == 0) {
                        aVar.f65592a.M(musicData.img, 10, false);
                    } else {
                        aVar.f65592a.M(String.valueOf(eVar.a()), 24, false);
                    }
                    if (this.f65590g != i2) {
                        aVar.f65593b.setVisibility(4);
                    } else if (aVar.f65593b.getVisibility() == 0) {
                        aVar.f65592a.setDrawBorder(false);
                    }
                    if (!TextUtils.isEmpty(eVar.b()) && eVar.b().equals(this.f65589f)) {
                        aVar.f65592a.setDrawBorder(true);
                    } else {
                        aVar.f65592a.setDrawBorder(false);
                    }
                } else if (itemViewType2 == 2) {
                    if (!TextUtils.isEmpty(eVar.b()) && eVar.b().equals(this.f65589f)) {
                        aVar.f65592a.setBackgroundResource(R.drawable.bg_beauty_item_choosed);
                    } else {
                        aVar.f65592a.setBackgroundResource(R.drawable.bg_beauty_item);
                    }
                }
                aVar.f65592a.setTag(eVar);
                aVar.f65592a.setTag(R.id.record_video_effect_holder, aVar);
                aVar.f65592a.setOnClickListener(this);
                aVar.f65594c.setText(eVar.b());
                aVar.f65595d = i2;
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return 3;
        }
        return invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VideoEffectLayout.h hVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, view) == null) && view.getId() == R.id.iv_effect && (view.getTag() instanceof e)) {
            e eVar = (e) view.getTag();
            if (eVar.c() == 3 && (eVar.d() instanceof MusicData)) {
                StatisticItem statisticItem = new StatisticItem("c12423");
                statisticItem.param("obj_id", ((MusicData) eVar.d()).id);
                statisticItem.param("obj_locate", this.f65588e.indexOf(eVar) + 1);
                statisticItem.param("obj_source", 1);
                TiebaStatic.log(statisticItem);
                if (view.getResources().getString(R.string.music_cloud).equals(eVar.b()) && (hVar = this.f65591h) != null) {
                    hVar.onEffectChoosed(eVar, view.getTag(R.id.record_video_effect_holder));
                    this.f65590g = this.f65588e.indexOf(eVar);
                    this.f65589f = eVar.b();
                }
                if (!TextUtils.isEmpty(eVar.b()) && eVar.b().equals(this.f65589f)) {
                    return;
                }
                if (!eVar.b().equals(view.getResources().getString(R.string.music_cloud))) {
                    this.f65590g = this.f65588e.indexOf(eVar);
                }
            } else {
                this.f65590g = this.f65588e.indexOf(eVar);
            }
            this.f65589f = eVar.b();
            notifyDataSetChanged();
            VideoEffectLayout.h hVar2 = this.f65591h;
            if (hVar2 != null) {
                hVar2.onEffectChoosed(eVar, view.getTag(R.id.record_video_effect_holder));
            }
        }
    }
}
