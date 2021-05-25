package tv.athena.revenue.payui.view;

import d.r.b.a.a.i.c.g;
import i.a.a.e.j.d;
import java.util.List;
/* loaded from: classes8.dex */
public interface IYYPayWayView extends i.a.a.e.m.a {

    /* loaded from: classes8.dex */
    public enum PayViewState {
        SELECTING_VIEW_STATE,
        WAITING_VIEW_STATE
    }

    /* loaded from: classes8.dex */
    public interface a {
        void a(d dVar, i.a.a.e.j.b bVar);
    }

    /* loaded from: classes8.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public List<g> f69606a;

        /* renamed from: b  reason: collision with root package name */
        public i.a.a.e.j.b f69607b;
    }

    void setCallback(a aVar);

    void setViewState(PayViewState payViewState);
}
