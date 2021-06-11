package com.kwad.sdk.contentalliance.detail.a;

import android.graphics.Rect;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ksad.lottie.LottieAnimationView;
import com.kwad.sdk.R;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.contentalliance.home.h;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayTouchViewPager;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayViewPager;
import com.kwad.sdk.contentalliance.profile.home.ProfileHomeParam;
import com.kwad.sdk.contentalliance.profile.home.model.ProfileResultData;
import com.kwad.sdk.contentalliance.profile.home.model.UserProfile;
import com.kwad.sdk.core.g.q;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.network.i;
import com.kwad.sdk.core.network.j;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.p;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d extends com.kwad.sdk.contentalliance.detail.b implements View.OnClickListener {
    public static AccelerateDecelerateInterpolator L = new AccelerateDecelerateInterpolator();
    public List<com.kwad.sdk.contentalliance.home.swipe.a> A;
    public com.kwad.sdk.contentalliance.home.swipe.c B;
    public com.kwad.sdk.contentalliance.detail.video.b C;
    public boolean D;
    public View J;
    public LottieAnimationView K;
    public boolean P;
    public i<q, ProfileResultData> Q;

    /* renamed from: b  reason: collision with root package name */
    public View f32570b;

    /* renamed from: c  reason: collision with root package name */
    public View f32571c;

    /* renamed from: d  reason: collision with root package name */
    public View f32572d;

    /* renamed from: e  reason: collision with root package name */
    public RecyclerView f32573e;

    /* renamed from: f  reason: collision with root package name */
    public SlidePlayViewPager f32574f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f32575g;

    /* renamed from: h  reason: collision with root package name */
    public int f32576h;

    /* renamed from: i  reason: collision with root package name */
    public View f32577i;
    public ImageView j;
    public TextView k;
    public TextView l;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public Float t;
    public int u;
    public int v;
    @Nullable
    public View w;
    public boolean x;
    public com.kwad.sdk.contentalliance.home.a.i y;
    public AdTemplate z;
    public float m = 1.0f;
    public SlidePlayTouchViewPager.a E = new SlidePlayTouchViewPager.a() { // from class: com.kwad.sdk.contentalliance.detail.a.d.6
        @Override // com.kwad.sdk.contentalliance.home.viewpager.SlidePlayTouchViewPager.a
        public void a() {
        }

        @Override // com.kwad.sdk.contentalliance.home.viewpager.SlidePlayTouchViewPager.a
        public void b() {
            d.this.D = true;
        }
    };
    public com.kwad.sdk.contentalliance.detail.video.e F = new f() { // from class: com.kwad.sdk.contentalliance.detail.a.d.7
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void b() {
            super.b();
            d.this.a(true);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void c() {
            super.c();
            d.this.a(false);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void d() {
            super.d();
            d.this.a(true);
        }
    };
    public com.kwad.sdk.contentalliance.a.a G = new com.kwad.sdk.contentalliance.a.b() { // from class: com.kwad.sdk.contentalliance.detail.a.d.8
        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void j() {
            String str;
            d.this.x = true;
            d.this.s();
            if (d.this.B != null) {
                d.this.B.a(d.this.H);
            }
            if (d.this.f32574f.getSourceType() == 1) {
                com.kwad.sdk.lib.widget.recycler.d dVar = (com.kwad.sdk.lib.widget.recycler.d) d.this.f32573e.getAdapter();
                if (dVar != null) {
                    com.kwad.sdk.contentalliance.home.c.b bVar = (com.kwad.sdk.contentalliance.home.c.b) dVar.c();
                    com.kwad.sdk.contentalliance.home.c.c e2 = bVar.e();
                    d.this.y.a(bVar.f(), d.this.z);
                    bVar.a(d.this.w);
                    bVar.a(d.this.z, d.this.C);
                    e2.b(d.this.z);
                    com.kwad.sdk.core.d.a.a("DetailProfileSlidePresenter", "scrollVerticallyToPosition becomesAttachedOnPageSelected");
                    d.this.f32573e.removeCallbacks(d.this.M);
                    d.this.f32573e.removeCallbacks(d.this.N);
                    d.this.f32573e.post(d.this.M);
                    e2.a(d.this.I);
                    d.this.f32573e.addOnScrollListener(d.this.O);
                }
                str = "becomesAttachedOnPageSelected mPosition" + ((com.kwad.sdk.contentalliance.detail.b) d.this).f32692a.f32721i + "--mSourceType=PROFILE--headerFooterAdapter=" + dVar;
            } else {
                str = "becomesAttachedOnPageSelected mPosition" + ((com.kwad.sdk.contentalliance.detail.b) d.this).f32692a.f32721i + "--mSourceType=FEED--headerFooterAdapter=" + d.this.f32573e.getAdapter();
            }
            com.kwad.sdk.core.d.a.a("DetailProfileSlidePresenter", str);
            d.this.D = false;
            d.this.f32574f.a(d.this.E);
        }

        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void k() {
            d.this.x = false;
            if (d.this.B.a() == d.this.H) {
                d.this.B.a((com.kwad.sdk.contentalliance.home.swipe.a) null);
            }
            d.this.f32573e.removeCallbacks(d.this.M);
            com.kwad.sdk.lib.widget.recycler.d dVar = (com.kwad.sdk.lib.widget.recycler.d) d.this.f32573e.getAdapter();
            if (dVar != null) {
                com.kwad.sdk.contentalliance.home.c.b bVar = (com.kwad.sdk.contentalliance.home.c.b) dVar.c();
                com.kwad.sdk.contentalliance.home.c.c e2 = bVar.e();
                if (d.this.f32574f.getSourceType() == 0) {
                    if (d.this.J != null) {
                        dVar.a(d.this.J);
                        d.this.K.d();
                        d.this.J = null;
                    }
                    e2.b(d.this.I);
                    e2.d();
                    bVar.k();
                    d.this.f32573e.removeOnScrollListener(d.this.O);
                    d.this.f32573e.setAdapter(null);
                    d.this.R.removeCallbacksAndMessages(null);
                } else {
                    e2.b(d.this.I);
                    e2.d();
                }
            }
            com.kwad.sdk.core.d.a.a("DetailProfileSlidePresenter", "becomesDetachedOnPageSelected mPosition" + ((com.kwad.sdk.contentalliance.detail.b) d.this).f32692a.f32721i + "--mSourceType=" + d.this.f32574f.getSourceType() + "--headerFooterAdapter=" + d.this.f32573e.getAdapter());
            d.this.f32574f.b(d.this.E);
        }
    };
    public final com.kwad.sdk.contentalliance.home.swipe.a H = new com.kwad.sdk.contentalliance.home.swipe.a() { // from class: com.kwad.sdk.contentalliance.detail.a.d.9
        @Override // com.kwad.sdk.contentalliance.home.swipe.a
        public void a(float f2) {
            View view;
            int i2;
            if (d.this.x) {
                if (d.this.f32573e.getAdapter() == null) {
                    d.this.f();
                }
                d.this.m = f2;
                d.this.a(f2);
                if (f2 == 1.0f) {
                    view = d.this.f32577i;
                    i2 = 8;
                } else {
                    view = d.this.f32577i;
                    i2 = 0;
                }
                view.setVisibility(i2);
                for (com.kwad.sdk.contentalliance.home.swipe.a aVar : d.this.A) {
                    aVar.a(f2);
                }
            }
        }

        @Override // com.kwad.sdk.contentalliance.home.swipe.a
        public float b(float f2) {
            if (d.this.t == null) {
                d dVar = d.this;
                dVar.t = Float.valueOf(dVar.f32572d.getTranslationX());
            }
            if (d.this.t.floatValue() == 0.0f) {
                if (f2 < 0.0f) {
                    return 0.0f;
                }
                return Math.min(1.0f, (Math.abs(f2) * 1.0f) / d.this.s);
            } else if (f2 > 0.0f) {
                return 1.0f;
            } else {
                return Math.max(0.0f, 1.0f - ((Math.abs(f2) * 1.0f) / d.this.s));
            }
        }

        @Override // com.kwad.sdk.contentalliance.home.swipe.a
        public void c(float f2) {
            if (d.this.x) {
                for (com.kwad.sdk.contentalliance.home.swipe.a aVar : d.this.A) {
                    aVar.c(f2);
                }
            }
        }

        @Override // com.kwad.sdk.contentalliance.home.swipe.a
        public void d(float f2) {
            if (d.this.x) {
                d.this.r();
                ae.b(d.this.o());
                d.this.f32574f.setEnabled(false);
                for (com.kwad.sdk.contentalliance.home.swipe.a aVar : d.this.A) {
                    aVar.d(f2);
                }
            }
        }

        @Override // com.kwad.sdk.contentalliance.home.swipe.a
        public void e(float f2) {
            View view;
            int i2;
            if (d.this.x) {
                d.this.t = null;
                d.this.m = f2;
                com.kwad.sdk.core.d.a.a("DetailProfileSlidePresenter", "updateFeed onSwipeFinish mPosition" + ((com.kwad.sdk.contentalliance.detail.b) d.this).f32692a.f32721i + "--mSourceType=" + d.this.f32574f.getSourceType());
                d.this.q();
                for (com.kwad.sdk.contentalliance.home.swipe.a aVar : d.this.A) {
                    aVar.e(f2);
                }
                if (f2 == 0.0f) {
                    com.kwad.sdk.core.report.e.n(d.this.z);
                }
                if (f2 == 1.0f) {
                    view = d.this.f32577i;
                    i2 = 8;
                } else {
                    view = d.this.f32577i;
                    i2 = 0;
                }
                view.setVisibility(i2);
            }
        }
    };
    public com.kwad.sdk.contentalliance.home.a.d I = new com.kwad.sdk.contentalliance.home.a.d() { // from class: com.kwad.sdk.contentalliance.detail.a.d.10
        @Override // com.kwad.sdk.contentalliance.home.a.d
        public void a(int i2, String str) {
            d.this.p();
            com.kwad.sdk.contentalliance.home.c.c e2 = ((com.kwad.sdk.contentalliance.home.c.b) ((com.kwad.sdk.lib.widget.recycler.d) d.this.f32573e.getAdapter()).c()).e();
            if (d.this.D || e2.c()) {
                if (com.kwad.sdk.core.network.f.f34497a.k == i2) {
                    p.a(d.this.o());
                } else if (com.kwad.sdk.core.network.f.f34503g.k != i2) {
                    p.b(d.this.o());
                } else if (com.kwad.sdk.core.config.c.X()) {
                    p.c(d.this.o());
                }
            }
        }

        @Override // com.kwad.sdk.contentalliance.home.a.d
        public void a(boolean z, int i2) {
            com.kwad.sdk.core.d.a.a("DetailProfileSlidePresenter", "updateFeed onFinishLoading mPosition" + ((com.kwad.sdk.contentalliance.detail.b) d.this).f32692a.f32721i + "--mSourceType=" + d.this.f32574f.getSourceType());
            if (z) {
                d.this.e();
                d.this.q();
                d.this.f32573e.removeCallbacks(d.this.M);
                d.this.f32573e.removeCallbacks(d.this.N);
                d.this.f32573e.post(d.this.N);
            } else {
                d.this.e();
                d.this.q();
            }
            d.this.p();
        }

        @Override // com.kwad.sdk.contentalliance.home.a.d
        public void a(boolean z, boolean z2, int i2, int i3) {
            if (z2) {
                d.this.h();
            }
        }
    };
    public Runnable M = new Runnable() { // from class: com.kwad.sdk.contentalliance.detail.a.d.11
        @Override // java.lang.Runnable
        public void run() {
            d.this.b(true);
        }
    };
    public Runnable N = new Runnable() { // from class: com.kwad.sdk.contentalliance.detail.a.d.12
        @Override // java.lang.Runnable
        public void run() {
            d.this.b(false);
        }
    };
    public RecyclerView.OnScrollListener O = new RecyclerView.OnScrollListener() { // from class: com.kwad.sdk.contentalliance.detail.a.d.2
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            super.onScrollStateChanged(recyclerView, i2);
            if (i2 == 1) {
                d.this.a(recyclerView);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            super.onScrolled(recyclerView, i2, i3);
            if (i2 > 0 || i3 > 0) {
                d.this.a(recyclerView);
            }
        }
    };
    public Handler R = new Handler();

    private int a(View view, int i2) {
        if (view == null) {
            return 0;
        }
        return view.getTop() - ((i2 - (view.getBottom() - view.getTop())) / 2);
    }

    private String a(String str) {
        return "M".equalsIgnoreCase(str) ? "他的作品" : "F".equalsIgnoreCase(str) ? "她的作品" : "ta的作品";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f2) {
        this.f32572d.setTranslationX(this.s * f2);
        int i2 = this.p;
        this.f32571c.setPivotX(((i2 * 1.0f) / (i2 + this.s)) * this.n);
        float f3 = 1.0f - (((this.s + this.p) * (1.0f - f2)) / this.n);
        this.f32571c.setScaleX(f3);
        this.f32571c.setScaleY(f3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(RecyclerView recyclerView) {
        com.kwad.sdk.contentalliance.home.c.b bVar = (com.kwad.sdk.contentalliance.home.c.b) ((com.kwad.sdk.lib.widget.recycler.d) this.f32573e.getAdapter()).c();
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        com.kwad.sdk.contentalliance.home.c.c e2 = bVar.e();
        if (layoutManager.getChildCount() <= 0 || !a((com.kwad.sdk.contentalliance.home.a.b) e2)) {
            return;
        }
        if (((RecyclerView.LayoutParams) layoutManager.getChildAt(layoutManager.getChildCount() - 1).getLayoutParams()).getViewAdapterPosition() >= bVar.getItemCount() - 1) {
            e2.a();
        }
    }

    private void a(KsFragment ksFragment, h hVar) {
        if (this.f32570b != null) {
            return;
        }
        View view = ksFragment.getParentFragment().getView();
        this.f32570b = view;
        this.f32571c = view.findViewById(R.id.ksad_home_content_layout);
        this.f32574f = (SlidePlayViewPager) this.f32570b.findViewById(R.id.ksad_slide_play_view_pager);
        this.f32576h = R.id.ksad_content_home_author_id;
        this.f32575g = (TextView) this.f32570b.findViewById(R.id.ksad_home_profile_title);
        this.f32577i = this.f32570b.findViewById(R.id.ksad_home_profile_bottom_layout);
        this.j = (ImageView) this.f32570b.findViewById(R.id.ksad_home_profile_author_icon);
        this.k = (TextView) this.f32570b.findViewById(R.id.ksad_home_profile_author_name);
        this.l = (TextView) this.f32570b.findViewById(R.id.ksad_home_profile_author_photo_count);
        this.f32572d = this.f32570b.findViewById(R.id.ksad_home_profile_layout);
        this.f32573e = (RecyclerView) this.f32570b.findViewById(R.id.ksad_home_profile_recycler_view);
        this.s = ao.a(o(), R.dimen.ksad_content_slide_profile_width);
        this.p = ao.a(o(), R.dimen.ksad_content_slide_profile_margin);
        this.q = this.s;
        this.u = ao.a(o(), 5.0f);
        this.v = ao.a(o(), R.dimen.ksad_content_slide_profile_item_height) + this.u;
        this.B = hVar.f33385g;
        this.y = hVar.f33386h;
        if (this.f32573e.getLayoutManager() == null) {
            this.f32573e.setLayoutManager(new LinearLayoutManager(this.f32573e.getContext()));
            this.f32573e.setItemAnimator(null);
            this.f32573e.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.kwad.sdk.contentalliance.detail.a.d.1
                @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
                public void getItemOffsets(Rect rect, View view2, RecyclerView recyclerView, RecyclerView.State state) {
                    rect.set(0, recyclerView.getChildAdapterPosition(view2) == 0 ? 0 : d.this.u, 0, 0);
                }
            });
        }
        this.j.setOnClickListener(this);
        this.k.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UserProfile userProfile) {
        long o = com.kwad.sdk.core.response.b.d.o(this.z.photoInfo);
        if (o == userProfile.authorId) {
            this.f32575g.setText(a(userProfile.authorGender));
            this.k.setText(userProfile.authorName);
            TextView textView = this.l;
            textView.setText("作品 " + ag.a(userProfile.ownerCount.publicPhotoCount));
            this.l.setTag(this.f32576h, String.valueOf(o));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        com.kwad.sdk.lib.widget.recycler.d dVar = (com.kwad.sdk.lib.widget.recycler.d) this.f32573e.getAdapter();
        if (dVar != null) {
            ((com.kwad.sdk.contentalliance.home.c.b) dVar.c()).a(this.z, this.w, z);
        }
    }

    private boolean a(com.kwad.sdk.contentalliance.home.a.b bVar) {
        return (bVar == null || bVar.b() == null || bVar.b().isEmpty()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        int indexOf;
        com.kwad.sdk.lib.widget.recycler.d dVar = (com.kwad.sdk.lib.widget.recycler.d) this.f32573e.getAdapter();
        if (dVar == null || (indexOf = ((com.kwad.sdk.contentalliance.home.c.b) dVar.c()).h().indexOf(this.z)) == -1) {
            return;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.f32573e.getLayoutManager();
        int height = this.f32573e.getHeight();
        if (!z) {
            int i2 = this.v;
            linearLayoutManager.scrollToPositionWithOffset(indexOf, ((height - i2) / 2) - (indexOf != 0 ? this.u + ((height % i2) / 2) : 0));
            return;
        }
        View findViewByPosition = linearLayoutManager.findViewByPosition(indexOf);
        if (findViewByPosition != null) {
            this.f32573e.smoothScrollBy(0, a(findViewByPosition, height), L);
            return;
        }
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        if (indexOf < findFirstVisibleItemPosition) {
            this.f32573e.smoothScrollBy(0, ((-(findFirstVisibleItemPosition - indexOf)) * this.v) + a(linearLayoutManager.findViewByPosition(findFirstVisibleItemPosition), height), L);
        } else if (indexOf > findLastVisibleItemPosition) {
            this.f32573e.smoothScrollBy(0, ((indexOf - findLastVisibleItemPosition) * this.v) + a(linearLayoutManager.findViewByPosition(findLastVisibleItemPosition), height), L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        com.kwad.sdk.contentalliance.home.c.b bVar = (com.kwad.sdk.contentalliance.home.c.b) ((com.kwad.sdk.lib.widget.recycler.d) this.f32573e.getAdapter()).c();
        bVar.a(bVar.e().b());
        bVar.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        com.kwad.sdk.core.d.a.a("DetailProfileSlidePresenter", "updateProfileFeed mPosition" + ((com.kwad.sdk.contentalliance.detail.b) this).f32692a.f32721i + "--mSourceType=" + this.f32574f.getSourceType());
        com.kwad.sdk.contentalliance.home.c.c cVar = new com.kwad.sdk.contentalliance.home.c.c(this.z.mAdScene);
        cVar.b(this.z);
        com.kwad.sdk.contentalliance.home.c.b bVar = new com.kwad.sdk.contentalliance.home.c.b(((com.kwad.sdk.contentalliance.detail.b) this).f32692a.k.getParentFragment(), this.f32573e, this.f32574f);
        bVar.a(this.w);
        bVar.a(this.z, this.C);
        bVar.a(cVar.b());
        bVar.a(cVar);
        com.kwad.sdk.lib.widget.recycler.d dVar = new com.kwad.sdk.lib.widget.recycler.d(bVar);
        View g2 = g();
        this.J = g2;
        if (!dVar.d(g2)) {
            dVar.c(this.J);
        }
        dVar.a(this.f32573e);
        this.f32573e.setAdapter(dVar);
        cVar.a(this.I);
        this.f32573e.addOnScrollListener(this.O);
        cVar.a(0);
    }

    private View g() {
        View view = this.J;
        if (view != null) {
            return view;
        }
        View a2 = ao.a((ViewGroup) this.f32573e, R.layout.ksad_content_slide_home_profile_loading_more, false);
        this.J = a2;
        LottieAnimationView lottieAnimationView = (LottieAnimationView) a2.findViewById(R.id.ksad_loading_lottie);
        this.K = lottieAnimationView;
        lottieAnimationView.setAnimation(R.raw.ksad_detail_loading_amin_new);
        this.K.setRepeatMode(1);
        this.K.setRepeatCount(-1);
        return this.J;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.J == null) {
            return;
        }
        this.K.b();
        this.K.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (this.J == null) {
            return;
        }
        this.K.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        float f2 = this.m;
        if (f2 == 1.0f) {
            com.kwad.sdk.contentalliance.home.a.i iVar = this.y;
            if (iVar.a(iVar.c())) {
                AdTemplate adTemplate = this.z;
                adTemplate.mIsLeftSlipStatus = 0;
                this.f32574f.a(adTemplate, 0);
            }
        } else if (f2 != 0.0f) {
            return;
        } else {
            com.kwad.sdk.contentalliance.home.c.b bVar = (com.kwad.sdk.contentalliance.home.c.b) ((com.kwad.sdk.lib.widget.recycler.d) this.f32573e.getAdapter()).c();
            com.kwad.sdk.contentalliance.home.c.c e2 = bVar.e();
            if (e2.c()) {
                return;
            }
            if (this.y.a(e2)) {
                AdTemplate adTemplate2 = this.z;
                adTemplate2.mIsLeftSlipStatus = 1;
                bVar.b(this.y.a(adTemplate2));
                this.f32574f.a(this.z, 1);
            } else {
                com.kwad.sdk.contentalliance.home.viewpager.a adapter = this.f32574f.getAdapter();
                List<AdTemplate> d2 = this.y.d();
                AdTemplate adTemplate3 = this.z;
                adapter.a(d2, adTemplate3, 1, this.y.a(adTemplate3), false);
            }
            if (e2.b().size() <= 1) {
                this.f32574f.setEnabled(false);
                return;
            }
        }
        this.f32574f.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        SceneImpl sceneImpl;
        final long o = com.kwad.sdk.core.response.b.d.o(this.z.photoInfo);
        String str = (String) this.l.getTag(this.f32576h);
        if ((TextUtils.isEmpty(str) || !str.equals(String.valueOf(o))) && !this.P && this.x && (sceneImpl = this.z.mAdScene) != null) {
            this.P = true;
            final com.kwad.sdk.core.g.a.f fVar = new com.kwad.sdk.core.g.a.f(sceneImpl);
            fVar.f34278b = sceneImpl.getPageScene();
            i<q, ProfileResultData> iVar = new i<q, ProfileResultData>() { // from class: com.kwad.sdk.contentalliance.detail.a.d.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.i
                @NonNull
                /* renamed from: a */
                public ProfileResultData b(String str2) {
                    JSONObject jSONObject = new JSONObject(str2);
                    ProfileResultData profileResultData = new ProfileResultData();
                    profileResultData.parseJson(jSONObject);
                    return profileResultData;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.a
                @NonNull
                /* renamed from: a */
                public q b() {
                    return new q(fVar, o);
                }
            };
            this.Q = iVar;
            iVar.a(new j<q, ProfileResultData>() { // from class: com.kwad.sdk.contentalliance.detail.a.d.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
                public void a(@NonNull q qVar, int i2, String str2) {
                    d.this.P = false;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
                public void a(@NonNull q qVar, @NonNull final ProfileResultData profileResultData) {
                    d.this.R.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.detail.a.d.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.a(profileResultData.userProfile);
                            d.this.P = false;
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        long o = com.kwad.sdk.core.response.b.d.o(this.z.photoInfo);
        String str = (String) this.f32577i.getTag(this.f32576h);
        if (TextUtils.isEmpty(str) || !str.equals(String.valueOf(o))) {
            KSImageLoader.loadCircleIconWithoutStroke(this.j, com.kwad.sdk.core.response.b.c.q(this.z), o().getResources().getDrawable(R.drawable.ksad_photo_default_author_icon_2));
            this.f32577i.setTag(this.f32576h, String.valueOf(o));
        }
    }

    private void t() {
        i<q, ProfileResultData> iVar = this.Q;
        if (iVar != null) {
            iVar.e();
        }
    }

    private void u() {
        PhotoInfo k = com.kwad.sdk.core.response.b.c.k(this.z);
        SceneImpl sceneImpl = this.z.mAdScene;
        if (sceneImpl != null) {
            v();
            ProfileHomeParam profileHomeParam = new ProfileHomeParam();
            profileHomeParam.mEntryScene = sceneImpl.entryScene;
            profileHomeParam.mAuthorId = com.kwad.sdk.core.response.b.d.o(k);
            profileHomeParam.mAuthorIcon = com.kwad.sdk.core.response.b.d.r(k);
            profileHomeParam.mAuthorName = com.kwad.sdk.core.response.b.d.p(k);
            profileHomeParam.mCurrentPhotoId = com.kwad.sdk.core.response.b.d.k(k);
            com.kwad.sdk.contentalliance.profile.home.a.a(o(), profileHomeParam);
        }
    }

    private void v() {
        com.kwad.sdk.core.report.e.a(this.z, 5, 3, 0);
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32692a;
        a(cVar.k, cVar.f32713a);
        this.R.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.detail.a.d.5
            @Override // java.lang.Runnable
            public void run() {
                d dVar = d.this;
                dVar.n = dVar.f32570b.getWidth();
                d dVar2 = d.this;
                dVar2.o = dVar2.f32570b.getHeight();
                d dVar3 = d.this;
                dVar3.r = (int) (((((dVar3.n - d.this.p) - d.this.q) * 1.0f) / d.this.n) * d.this.o);
                com.kwad.sdk.core.d.a.a("DetailProfileSlidePresenter", "mScaledHeight=" + d.this.r + "--mHomeFragmentWidth" + d.this.n + "--mHomeFragmentHeight=" + d.this.o);
                if (d.this.f32573e.getHeight() != d.this.r) {
                    ViewGroup.LayoutParams layoutParams = d.this.f32573e.getLayoutParams();
                    layoutParams.height = d.this.r;
                    d.this.f32573e.setLayoutParams(layoutParams);
                    ViewGroup.LayoutParams layoutParams2 = d.this.f32577i.getLayoutParams();
                    layoutParams2.height = (d.this.o - d.this.r) / 2;
                    d.this.f32577i.setLayoutParams(layoutParams2);
                }
            }
        });
        com.kwad.sdk.contentalliance.detail.c cVar2 = ((com.kwad.sdk.contentalliance.detail.b) this).f32692a;
        this.z = cVar2.j;
        this.A = cVar2.f32717e;
        cVar2.f32714b.add(this.G);
        this.m = this.f32574f.getSourceType() == 1 ? 0.0f : 1.0f;
        com.kwad.sdk.contentalliance.detail.video.b bVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32692a.m;
        this.C = bVar;
        if (bVar != null) {
            bVar.a(this.F);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.contentalliance.detail.b) this).f32692a.f32714b.remove(this.G);
        com.kwad.sdk.contentalliance.detail.video.b bVar = this.C;
        if (bVar != null) {
            bVar.b(this.F);
        }
        t();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.w = b(R.id.ksad_video_control_button);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        this.f32573e.removeCallbacks(this.M);
        this.f32573e.removeCallbacks(this.N);
        this.R.removeCallbacksAndMessages(null);
        t();
        com.kwad.sdk.lib.widget.recycler.d dVar = (com.kwad.sdk.lib.widget.recycler.d) this.f32573e.getAdapter();
        if (dVar != null) {
            com.kwad.sdk.contentalliance.home.c.b bVar = (com.kwad.sdk.contentalliance.home.c.b) dVar.c();
            com.kwad.sdk.contentalliance.home.c.c e2 = bVar.e();
            e2.b(this.I);
            e2.d();
            bVar.k();
            this.f32573e.removeOnScrollListener(this.O);
            this.f32573e.setAdapter(null);
            LottieAnimationView lottieAnimationView = this.K;
            if (lottieAnimationView != null) {
                lottieAnimationView.d();
            }
        }
        try {
            a(1.0f);
        } catch (Exception e3) {
            com.kwad.sdk.core.d.a.b(e3);
        }
        com.kwad.sdk.contentalliance.home.a.i iVar = this.y;
        if (iVar.a(iVar.c())) {
            this.f32574f.a(this.z, 0);
        }
        this.f32574f.setEnabled(true);
        this.f32574f.b(this.E);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (ao.a()) {
            return;
        }
        if (view == this.j || view == this.k) {
            u();
        }
    }
}
