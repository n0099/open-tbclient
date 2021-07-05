package d.a.s0.z3.m.e.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.external.sticker.data.QmStickerItem;
import com.baidu.tieba.view.widget.recordeffect.RecordEffectLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes9.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<QmStickerItem> f70149e;

    /* renamed from: f  reason: collision with root package name */
    public RecordEffectLayout.i f70150f;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f70151e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f70152f;

        public a(b bVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70152f = bVar;
            this.f70151e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || ((QmStickerItem) this.f70152f.f70149e.get(this.f70151e * 2)).isSelect || this.f70152f.f70150f == null) {
                return;
            }
            this.f70152f.f70150f.a((QmStickerItem) this.f70152f.f70149e.get(this.f70151e * 2));
        }
    }

    /* renamed from: d.a.s0.z3.m.e.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class View$OnClickListenerC1923b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f70153e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f70154f;

        public View$OnClickListenerC1923b(b bVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70154f = bVar;
            this.f70153e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || ((QmStickerItem) this.f70154f.f70149e.get((this.f70153e * 2) + 1)).isSelect || this.f70154f.f70150f == null) {
                return;
            }
            this.f70154f.f70150f.a((QmStickerItem) this.f70154f.f70149e.get((this.f70153e * 2) + 1));
        }
    }

    /* loaded from: classes9.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public RelativeLayout f70155a;

        /* renamed from: b  reason: collision with root package name */
        public RelativeLayout f70156b;

        /* renamed from: c  reason: collision with root package name */
        public TbImageView f70157c;

        /* renamed from: d  reason: collision with root package name */
        public TbImageView f70158d;

        /* renamed from: e  reason: collision with root package name */
        public TbImageView f70159e;

        /* renamed from: f  reason: collision with root package name */
        public TbImageView f70160f;

        /* renamed from: g  reason: collision with root package name */
        public ProgressBar f70161g;

        /* renamed from: h  reason: collision with root package name */
        public ProgressBar f70162h;

        /* renamed from: i  reason: collision with root package name */
        public ImageView f70163i;

        public c(b bVar) {
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
                }
            }
        }
    }

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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: c */
    public QmStickerItem getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? (QmStickerItem) ListUtils.getItem(this.f70149e, i2) : (QmStickerItem) invokeI.objValue;
    }

    public void d(List<QmStickerItem> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.f70149e = list;
        }
    }

    public void e(RecordEffectLayout.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iVar) == null) {
            this.f70150f = iVar;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (ListUtils.isEmpty(this.f70149e)) {
                return 0;
            }
            return (int) Math.ceil(this.f70149e.size() / 2.0d);
        }
        return invokeV.intValue;
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
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.capture_list_item_sticker, (ViewGroup) null);
                cVar = new c(this);
                cVar.f70157c = (TbImageView) view.findViewById(R.id.top_sticker);
                cVar.f70158d = (TbImageView) view.findViewById(R.id.bottom_sticker);
                cVar.f70155a = (RelativeLayout) view.findViewById(R.id.top_container);
                cVar.f70163i = (ImageView) view.findViewById(R.id.no_sticker);
                cVar.f70156b = (RelativeLayout) view.findViewById(R.id.bottom_container);
                cVar.f70159e = (TbImageView) view.findViewById(R.id.top_need_download);
                cVar.f70160f = (TbImageView) view.findViewById(R.id.bottom_need_download);
                cVar.f70161g = (ProgressBar) view.findViewById(R.id.top_progressbar);
                cVar.f70162h = (ProgressBar) view.findViewById(R.id.bottom_progressbar);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            cVar.f70157c.setAutoChangeStyle(false);
            cVar.f70158d.setAutoChangeStyle(false);
            cVar.f70159e.setAutoChangeStyle(false);
            cVar.f70160f.setAutoChangeStyle(false);
            cVar.f70157c.setGifIconSupport(false);
            cVar.f70158d.setGifIconSupport(false);
            int i3 = i2 * 2;
            if (ListUtils.getItem(this.f70149e, i3) instanceof QmStickerItem) {
                cVar.f70155a.setVisibility(0);
                if (this.f70149e.get(i3).id == -1) {
                    cVar.f70163i.setVisibility(0);
                    cVar.f70157c.setVisibility(8);
                    cVar.f70163i.setImageResource(R.drawable.icon_video_sticker_no);
                } else {
                    cVar.f70163i.setVisibility(8);
                    cVar.f70157c.setVisibility(0);
                    cVar.f70157c.M(this.f70149e.get(i3).bgurl, 10, true);
                }
                cVar.f70155a.setOnClickListener(new a(this, i2));
                if (this.f70149e.get(i3).isDownLoading) {
                    cVar.f70161g.setVisibility(0);
                    cVar.f70159e.setVisibility(8);
                } else {
                    cVar.f70161g.setVisibility(8);
                    if (this.f70149e.get(i3).isLocalSource) {
                        cVar.f70159e.setVisibility(8);
                    } else {
                        cVar.f70159e.setVisibility(0);
                    }
                }
                if (this.f70149e.get(i3).isSelect) {
                    cVar.f70155a.setBackgroundResource(R.drawable.select_sticker_bg);
                } else {
                    cVar.f70155a.setBackgroundResource(R.color.transparent);
                }
            } else {
                cVar.f70155a.setVisibility(8);
            }
            int i4 = i3 + 1;
            if (ListUtils.getItem(this.f70149e, i4) instanceof QmStickerItem) {
                cVar.f70156b.setVisibility(0);
                cVar.f70158d.M(this.f70149e.get(i4).bgurl, 10, true);
                cVar.f70156b.setOnClickListener(new View$OnClickListenerC1923b(this, i2));
                if (this.f70149e.get(i4).isDownLoading) {
                    cVar.f70162h.setVisibility(0);
                    cVar.f70160f.setVisibility(8);
                } else {
                    cVar.f70162h.setVisibility(8);
                    if (this.f70149e.get(i4).isLocalSource) {
                        cVar.f70160f.setVisibility(8);
                    } else {
                        cVar.f70160f.setVisibility(0);
                    }
                }
                if (this.f70149e.get(i4).isSelect) {
                    cVar.f70156b.setBackgroundResource(R.drawable.select_sticker_bg);
                } else {
                    cVar.f70156b.setBackgroundResource(R.color.transparent);
                }
            } else {
                cVar.f70156b.setVisibility(8);
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
