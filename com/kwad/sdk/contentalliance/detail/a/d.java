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
/* loaded from: classes5.dex */
public class d extends com.kwad.sdk.contentalliance.detail.b implements View.OnClickListener {
    private static AccelerateDecelerateInterpolator L = new AccelerateDecelerateInterpolator();
    private List<com.kwad.sdk.contentalliance.home.swipe.a> A;
    private com.kwad.sdk.contentalliance.home.swipe.c B;
    private com.kwad.sdk.contentalliance.detail.video.b C;
    private boolean D;
    private View J;
    private LottieAnimationView K;
    private boolean P;
    private i<q, ProfileResultData> Q;

    /* renamed from: b  reason: collision with root package name */
    private View f8624b;
    private View c;
    private View d;
    private RecyclerView e;
    private SlidePlayViewPager f;
    private TextView g;
    private int h;
    private View i;
    private ImageView j;
    private TextView k;
    private TextView l;
    private int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private Float t;
    private int u;
    private int v;
    @Nullable
    private View w;
    private boolean x;
    private com.kwad.sdk.contentalliance.home.a.i y;
    private AdTemplate z;
    private float m = 1.0f;
    private SlidePlayTouchViewPager.a E = new SlidePlayTouchViewPager.a() { // from class: com.kwad.sdk.contentalliance.detail.a.d.6
        @Override // com.kwad.sdk.contentalliance.home.viewpager.SlidePlayTouchViewPager.a
        public void a() {
        }

        @Override // com.kwad.sdk.contentalliance.home.viewpager.SlidePlayTouchViewPager.a
        public void b() {
            d.this.D = true;
        }
    };
    private com.kwad.sdk.contentalliance.detail.video.e F = new f() { // from class: com.kwad.sdk.contentalliance.detail.a.d.7
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
    private com.kwad.sdk.contentalliance.a.a G = new com.kwad.sdk.contentalliance.a.b() { // from class: com.kwad.sdk.contentalliance.detail.a.d.8
        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void j() {
            d.this.x = true;
            d.this.s();
            if (d.this.B != null) {
                d.this.B.a(d.this.H);
            }
            if (d.this.f.getSourceType() == 1) {
                com.kwad.sdk.lib.widget.recycler.d dVar = (com.kwad.sdk.lib.widget.recycler.d) d.this.e.getAdapter();
                if (dVar != null) {
                    com.kwad.sdk.contentalliance.home.c.b bVar = (com.kwad.sdk.contentalliance.home.c.b) dVar.c();
                    com.kwad.sdk.contentalliance.home.c.c e = bVar.e();
                    d.this.y.a(bVar.f(), d.this.z);
                    bVar.a(d.this.w);
                    bVar.a(d.this.z, d.this.C);
                    e.b(d.this.z);
                    com.kwad.sdk.core.d.a.a("DetailProfileSlidePresenter", "scrollVerticallyToPosition becomesAttachedOnPageSelected");
                    d.this.e.removeCallbacks(d.this.M);
                    d.this.e.removeCallbacks(d.this.N);
                    d.this.e.post(d.this.M);
                    e.a(d.this.I);
                    d.this.e.addOnScrollListener(d.this.O);
                }
                com.kwad.sdk.core.d.a.a("DetailProfileSlidePresenter", "becomesAttachedOnPageSelected mPosition" + d.this.f8693a.i + "--mSourceType=PROFILE--headerFooterAdapter=" + dVar);
            } else {
                com.kwad.sdk.core.d.a.a("DetailProfileSlidePresenter", "becomesAttachedOnPageSelected mPosition" + d.this.f8693a.i + "--mSourceType=FEED--headerFooterAdapter=" + d.this.e.getAdapter());
            }
            d.this.D = false;
            d.this.f.a(d.this.E);
        }

        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void k() {
            d.this.x = false;
            if (d.this.B.a() == d.this.H) {
                d.this.B.a((com.kwad.sdk.contentalliance.home.swipe.a) null);
            }
            d.this.e.removeCallbacks(d.this.M);
            com.kwad.sdk.lib.widget.recycler.d dVar = (com.kwad.sdk.lib.widget.recycler.d) d.this.e.getAdapter();
            if (dVar != null) {
                com.kwad.sdk.contentalliance.home.c.b bVar = (com.kwad.sdk.contentalliance.home.c.b) dVar.c();
                com.kwad.sdk.contentalliance.home.c.c e = bVar.e();
                if (d.this.f.getSourceType() == 0) {
                    if (d.this.J != null) {
                        dVar.a(d.this.J);
                        d.this.K.d();
                        d.this.J = null;
                    }
                    e.b(d.this.I);
                    e.d();
                    bVar.k();
                    d.this.e.removeOnScrollListener(d.this.O);
                    d.this.e.setAdapter(null);
                    d.this.R.removeCallbacksAndMessages(null);
                } else {
                    e.b(d.this.I);
                    e.d();
                }
            }
            com.kwad.sdk.core.d.a.a("DetailProfileSlidePresenter", "becomesDetachedOnPageSelected mPosition" + d.this.f8693a.i + "--mSourceType=" + d.this.f.getSourceType() + "--headerFooterAdapter=" + d.this.e.getAdapter());
            d.this.f.b(d.this.E);
        }
    };
    private final com.kwad.sdk.contentalliance.home.swipe.a H = new com.kwad.sdk.contentalliance.home.swipe.a() { // from class: com.kwad.sdk.contentalliance.detail.a.d.9
        @Override // com.kwad.sdk.contentalliance.home.swipe.a
        public void a(float f) {
            if (d.this.x) {
                if (d.this.e.getAdapter() == null) {
                    d.this.f();
                }
                d.this.m = f;
                d.this.a(f);
                if (f == 1.0f) {
                    d.this.i.setVisibility(8);
                } else {
                    d.this.i.setVisibility(0);
                }
                for (com.kwad.sdk.contentalliance.home.swipe.a aVar : d.this.A) {
                    aVar.a(f);
                }
            }
        }

        @Override // com.kwad.sdk.contentalliance.home.swipe.a
        public float b(float f) {
            if (d.this.t == null) {
                d.this.t = Float.valueOf(d.this.d.getTranslationX());
            }
            if (d.this.t.floatValue() == 0.0f) {
                if (f < 0.0f) {
                    return 0.0f;
                }
                return Math.min(1.0f, (Math.abs(f) * 1.0f) / d.this.s);
            } else if (f > 0.0f) {
                return 1.0f;
            } else {
                return Math.max(0.0f, 1.0f - ((Math.abs(f) * 1.0f) / d.this.s));
            }
        }

        @Override // com.kwad.sdk.contentalliance.home.swipe.a
        public void c(float f) {
            if (d.this.x) {
                for (com.kwad.sdk.contentalliance.home.swipe.a aVar : d.this.A) {
                    aVar.c(f);
                }
            }
        }

        @Override // com.kwad.sdk.contentalliance.home.swipe.a
        public void d(float f) {
            if (d.this.x) {
                d.this.r();
                ae.b(d.this.o());
                d.this.f.setEnabled(false);
                for (com.kwad.sdk.contentalliance.home.swipe.a aVar : d.this.A) {
                    aVar.d(f);
                }
            }
        }

        @Override // com.kwad.sdk.contentalliance.home.swipe.a
        public void e(float f) {
            if (d.this.x) {
                d.this.t = null;
                d.this.m = f;
                com.kwad.sdk.core.d.a.a("DetailProfileSlidePresenter", "updateFeed onSwipeFinish mPosition" + d.this.f8693a.i + "--mSourceType=" + d.this.f.getSourceType());
                d.this.q();
                for (com.kwad.sdk.contentalliance.home.swipe.a aVar : d.this.A) {
                    aVar.e(f);
                }
                if (f == 0.0f) {
                    com.kwad.sdk.core.report.e.n(d.this.z);
                }
                if (f == 1.0f) {
                    d.this.i.setVisibility(8);
                } else {
                    d.this.i.setVisibility(0);
                }
            }
        }
    };
    private com.kwad.sdk.contentalliance.home.a.d I = new com.kwad.sdk.contentalliance.home.a.d() { // from class: com.kwad.sdk.contentalliance.detail.a.d.10
        @Override // com.kwad.sdk.contentalliance.home.a.d
        public void a(int i, String str) {
            d.this.p();
            com.kwad.sdk.contentalliance.home.c.c e = ((com.kwad.sdk.contentalliance.home.c.b) ((com.kwad.sdk.lib.widget.recycler.d) d.this.e.getAdapter()).c()).e();
            if (d.this.D || e.c()) {
                if (com.kwad.sdk.core.network.f.f9621a.k == i) {
                    p.a(d.this.o());
                } else if (com.kwad.sdk.core.network.f.g.k != i) {
                    p.b(d.this.o());
                } else if (com.kwad.sdk.core.config.c.X()) {
                    p.c(d.this.o());
                }
            }
        }

        @Override // com.kwad.sdk.contentalliance.home.a.d
        public void a(boolean z, int i) {
            com.kwad.sdk.core.d.a.a("DetailProfileSlidePresenter", "updateFeed onFinishLoading mPosition" + d.this.f8693a.i + "--mSourceType=" + d.this.f.getSourceType());
            if (z) {
                d.this.e();
                d.this.q();
                d.this.e.removeCallbacks(d.this.M);
                d.this.e.removeCallbacks(d.this.N);
                d.this.e.post(d.this.N);
            } else {
                d.this.e();
                d.this.q();
            }
            d.this.p();
        }

        @Override // com.kwad.sdk.contentalliance.home.a.d
        public void a(boolean z, boolean z2, int i, int i2) {
            if (z2) {
                d.this.h();
            }
        }
    };
    private Runnable M = new Runnable() { // from class: com.kwad.sdk.contentalliance.detail.a.d.11
        @Override // java.lang.Runnable
        public void run() {
            d.this.b(true);
        }
    };
    private Runnable N = new Runnable() { // from class: com.kwad.sdk.contentalliance.detail.a.d.12
        @Override // java.lang.Runnable
        public void run() {
            d.this.b(false);
        }
    };
    private RecyclerView.OnScrollListener O = new RecyclerView.OnScrollListener() { // from class: com.kwad.sdk.contentalliance.detail.a.d.2
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 1) {
                d.this.a(recyclerView);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i > 0 || i2 > 0) {
                d.this.a(recyclerView);
            }
        }
    };
    private Handler R = new Handler();

    private int a(View view, int i) {
        if (view == null) {
            return 0;
        }
        return view.getTop() - ((i - (view.getBottom() - view.getTop())) / 2);
    }

    private String a(String str) {
        return "M".equalsIgnoreCase(str) ? "他的作品" : "F".equalsIgnoreCase(str) ? "她的作品" : "ta的作品";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f) {
        this.d.setTranslationX(this.s * f);
        this.c.setPivotX(((this.p * 1.0f) / (this.p + this.s)) * this.n);
        float f2 = 1.0f - (((this.s + this.p) * (1.0f - f)) / this.n);
        this.c.setScaleX(f2);
        this.c.setScaleY(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(RecyclerView recyclerView) {
        com.kwad.sdk.contentalliance.home.c.b bVar = (com.kwad.sdk.contentalliance.home.c.b) ((com.kwad.sdk.lib.widget.recycler.d) this.e.getAdapter()).c();
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        com.kwad.sdk.contentalliance.home.c.c e = bVar.e();
        if (layoutManager.getChildCount() <= 0 || !a((com.kwad.sdk.contentalliance.home.a.b) e)) {
            return;
        }
        if (((RecyclerView.LayoutParams) layoutManager.getChildAt(layoutManager.getChildCount() - 1).getLayoutParams()).getViewAdapterPosition() >= bVar.getItemCount() - 1) {
            e.a();
        }
    }

    private void a(KsFragment ksFragment, h hVar) {
        if (this.f8624b != null) {
            return;
        }
        this.f8624b = ksFragment.getParentFragment().getView();
        this.c = this.f8624b.findViewById(R.id.ksad_home_content_layout);
        this.f = (SlidePlayViewPager) this.f8624b.findViewById(R.id.ksad_slide_play_view_pager);
        this.h = R.id.ksad_content_home_author_id;
        this.g = (TextView) this.f8624b.findViewById(R.id.ksad_home_profile_title);
        this.i = this.f8624b.findViewById(R.id.ksad_home_profile_bottom_layout);
        this.j = (ImageView) this.f8624b.findViewById(R.id.ksad_home_profile_author_icon);
        this.k = (TextView) this.f8624b.findViewById(R.id.ksad_home_profile_author_name);
        this.l = (TextView) this.f8624b.findViewById(R.id.ksad_home_profile_author_photo_count);
        this.d = this.f8624b.findViewById(R.id.ksad_home_profile_layout);
        this.e = (RecyclerView) this.f8624b.findViewById(R.id.ksad_home_profile_recycler_view);
        this.s = ao.a(o(), R.dimen.ksad_content_slide_profile_width);
        this.p = ao.a(o(), R.dimen.ksad_content_slide_profile_margin);
        this.q = this.s;
        this.u = ao.a(o(), 5.0f);
        this.v = ao.a(o(), R.dimen.ksad_content_slide_profile_item_height) + this.u;
        this.B = hVar.g;
        this.y = hVar.h;
        if (this.e.getLayoutManager() == null) {
            this.e.setLayoutManager(new LinearLayoutManager(this.e.getContext()));
            this.e.setItemAnimator(null);
            this.e.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.kwad.sdk.contentalliance.detail.a.d.1
                @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
                public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                    rect.set(0, recyclerView.getChildAdapterPosition(view) == 0 ? 0 : d.this.u, 0, 0);
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
            this.g.setText(a(userProfile.authorGender));
            this.k.setText(userProfile.authorName);
            this.l.setText("作品 " + ag.a(userProfile.ownerCount.publicPhotoCount));
            this.l.setTag(this.h, String.valueOf(o));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        com.kwad.sdk.lib.widget.recycler.d dVar = (com.kwad.sdk.lib.widget.recycler.d) this.e.getAdapter();
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
        com.kwad.sdk.lib.widget.recycler.d dVar = (com.kwad.sdk.lib.widget.recycler.d) this.e.getAdapter();
        if (dVar == null || (indexOf = ((com.kwad.sdk.contentalliance.home.c.b) dVar.c()).h().indexOf(this.z)) == -1) {
            return;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.e.getLayoutManager();
        int height = this.e.getHeight();
        if (!z) {
            linearLayoutManager.scrollToPositionWithOffset(indexOf, ((height - this.v) / 2) - (indexOf != 0 ? this.u + ((height % this.v) / 2) : 0));
            return;
        }
        View findViewByPosition = linearLayoutManager.findViewByPosition(indexOf);
        if (findViewByPosition != null) {
            this.e.smoothScrollBy(0, a(findViewByPosition, height), L);
            return;
        }
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        if (indexOf < findFirstVisibleItemPosition) {
            this.e.smoothScrollBy(0, a(linearLayoutManager.findViewByPosition(findFirstVisibleItemPosition), height) + ((-(findFirstVisibleItemPosition - indexOf)) * this.v), L);
        } else if (indexOf > findLastVisibleItemPosition) {
            this.e.smoothScrollBy(0, a(linearLayoutManager.findViewByPosition(findLastVisibleItemPosition), height) + ((indexOf - findLastVisibleItemPosition) * this.v), L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        com.kwad.sdk.contentalliance.home.c.b bVar = (com.kwad.sdk.contentalliance.home.c.b) ((com.kwad.sdk.lib.widget.recycler.d) this.e.getAdapter()).c();
        bVar.a(bVar.e().b());
        bVar.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        com.kwad.sdk.core.d.a.a("DetailProfileSlidePresenter", "updateProfileFeed mPosition" + this.f8693a.i + "--mSourceType=" + this.f.getSourceType());
        com.kwad.sdk.contentalliance.home.c.c cVar = new com.kwad.sdk.contentalliance.home.c.c(this.z.mAdScene);
        cVar.b(this.z);
        com.kwad.sdk.contentalliance.home.c.b bVar = new com.kwad.sdk.contentalliance.home.c.b(this.f8693a.k.getParentFragment(), this.e, this.f);
        bVar.a(this.w);
        bVar.a(this.z, this.C);
        bVar.a(cVar.b());
        bVar.a(cVar);
        com.kwad.sdk.lib.widget.recycler.d dVar = new com.kwad.sdk.lib.widget.recycler.d(bVar);
        this.J = g();
        if (!dVar.d(this.J)) {
            dVar.c(this.J);
        }
        dVar.a(this.e);
        this.e.setAdapter(dVar);
        cVar.a(this.I);
        this.e.addOnScrollListener(this.O);
        cVar.a(0);
    }

    private View g() {
        if (this.J != null) {
            return this.J;
        }
        this.J = ao.a((ViewGroup) this.e, R.layout.ksad_content_slide_home_profile_loading_more, false);
        this.K = (LottieAnimationView) this.J.findViewById(R.id.ksad_loading_lottie);
        this.K.setAnimation(R.raw.ksad_detail_loading_amin_new);
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
        if (this.m == 1.0f) {
            if (this.y.a(this.y.c())) {
                this.z.mIsLeftSlipStatus = 0;
                this.f.a(this.z, 0);
            }
            this.f.setEnabled(true);
        } else if (this.m == 0.0f) {
            com.kwad.sdk.contentalliance.home.c.b bVar = (com.kwad.sdk.contentalliance.home.c.b) ((com.kwad.sdk.lib.widget.recycler.d) this.e.getAdapter()).c();
            com.kwad.sdk.contentalliance.home.c.c e = bVar.e();
            if (e.c()) {
                return;
            }
            if (this.y.a(e)) {
                this.z.mIsLeftSlipStatus = 1;
                bVar.b(this.y.a(this.z));
                this.f.a(this.z, 1);
            } else {
                this.f.getAdapter().a(this.y.d(), this.z, 1, this.y.a(this.z), false);
            }
            if (e.b().size() <= 1) {
                this.f.setEnabled(false);
            } else {
                this.f.setEnabled(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        SceneImpl sceneImpl;
        final long o = com.kwad.sdk.core.response.b.d.o(this.z.photoInfo);
        String str = (String) this.l.getTag(this.h);
        if ((TextUtils.isEmpty(str) || !str.equals(String.valueOf(o))) && !this.P && this.x && (sceneImpl = this.z.mAdScene) != null) {
            this.P = true;
            final com.kwad.sdk.core.g.a.f fVar = new com.kwad.sdk.core.g.a.f(sceneImpl);
            fVar.f9466b = sceneImpl.getPageScene();
            this.Q = new i<q, ProfileResultData>() { // from class: com.kwad.sdk.contentalliance.detail.a.d.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
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
            this.Q.a(new j<q, ProfileResultData>() { // from class: com.kwad.sdk.contentalliance.detail.a.d.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
                public void a(@NonNull q qVar, int i, String str2) {
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
        String str = (String) this.i.getTag(this.h);
        if (TextUtils.isEmpty(str) || !str.equals(String.valueOf(o))) {
            KSImageLoader.loadCircleIconWithoutStroke(this.j, com.kwad.sdk.core.response.b.c.q(this.z), o().getResources().getDrawable(R.drawable.ksad_photo_default_author_icon_2));
            this.i.setTag(this.h, String.valueOf(o));
        }
    }

    private void t() {
        if (this.Q != null) {
            this.Q.e();
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        a(this.f8693a.k, this.f8693a.f8702a);
        this.R.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.detail.a.d.5
            @Override // java.lang.Runnable
            public void run() {
                d.this.n = d.this.f8624b.getWidth();
                d.this.o = d.this.f8624b.getHeight();
                d.this.r = (int) (((((d.this.n - d.this.p) - d.this.q) * 1.0f) / d.this.n) * d.this.o);
                com.kwad.sdk.core.d.a.a("DetailProfileSlidePresenter", "mScaledHeight=" + d.this.r + "--mHomeFragmentWidth" + d.this.n + "--mHomeFragmentHeight=" + d.this.o);
                if (d.this.e.getHeight() != d.this.r) {
                    ViewGroup.LayoutParams layoutParams = d.this.e.getLayoutParams();
                    layoutParams.height = d.this.r;
                    d.this.e.setLayoutParams(layoutParams);
                    ViewGroup.LayoutParams layoutParams2 = d.this.i.getLayoutParams();
                    layoutParams2.height = (d.this.o - d.this.r) / 2;
                    d.this.i.setLayoutParams(layoutParams2);
                }
            }
        });
        this.z = this.f8693a.j;
        this.A = this.f8693a.e;
        this.f8693a.f8703b.add(this.G);
        this.m = this.f.getSourceType() == 1 ? 0.0f : 1.0f;
        this.C = this.f8693a.m;
        if (this.C != null) {
            this.C.a(this.F);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f8693a.f8703b.remove(this.G);
        if (this.C != null) {
            this.C.b(this.F);
        }
        t();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.w = b(R.id.ksad_video_control_button);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        this.e.removeCallbacks(this.M);
        this.e.removeCallbacks(this.N);
        this.R.removeCallbacksAndMessages(null);
        t();
        com.kwad.sdk.lib.widget.recycler.d dVar = (com.kwad.sdk.lib.widget.recycler.d) this.e.getAdapter();
        if (dVar != null) {
            com.kwad.sdk.contentalliance.home.c.b bVar = (com.kwad.sdk.contentalliance.home.c.b) dVar.c();
            com.kwad.sdk.contentalliance.home.c.c e = bVar.e();
            e.b(this.I);
            e.d();
            bVar.k();
            this.e.removeOnScrollListener(this.O);
            this.e.setAdapter(null);
            if (this.K != null) {
                this.K.d();
            }
        }
        try {
            a(1.0f);
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.b(e2);
        }
        if (this.y.a(this.y.c())) {
            this.f.a(this.z, 0);
        }
        this.f.setEnabled(true);
        this.f.b(this.E);
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
