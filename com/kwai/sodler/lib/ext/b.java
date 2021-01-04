package com.kwai.sodler.lib.ext;

import com.kwai.sodler.lib.a.a;
import com.kwai.sodler.lib.a.f;
import com.kwai.sodler.lib.g;
import com.kwai.sodler.lib.h;
/* loaded from: classes5.dex */
public interface b<P extends com.kwai.sodler.lib.a.a, R extends f<P>> {

    /* loaded from: classes5.dex */
    public static class a implements b<g, h> {
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.kwai.sodler.lib.ext.b
        public void a(h hVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.kwai.sodler.lib.ext.b
        public void a(h hVar, PluginError pluginError) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.kwai.sodler.lib.ext.b
        public void a(h hVar, g gVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.kwai.sodler.lib.ext.b
        public void b(h hVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwai.sodler.lib.ext.b
        public void c(h hVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwai.sodler.lib.ext.b
        public void d(h hVar) {
        }
    }

    void a(R r);

    void a(R r, P p);

    void a(R r, PluginError pluginError);

    void b(R r);

    void c(R r);

    void d(R r);
}
