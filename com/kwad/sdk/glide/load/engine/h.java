package com.kwad.sdk.glide.load.engine;

import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.EncodeStrategy;
/* loaded from: classes3.dex */
public abstract class h {

    /* renamed from: a  reason: collision with root package name */
    public static final h f10218a = new h() { // from class: com.kwad.sdk.glide.load.engine.h.1
        @Override // com.kwad.sdk.glide.load.engine.h
        public boolean a() {
            return true;
        }

        @Override // com.kwad.sdk.glide.load.engine.h
        public boolean a(DataSource dataSource) {
            return dataSource == DataSource.REMOTE;
        }

        @Override // com.kwad.sdk.glide.load.engine.h
        public boolean a(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return (dataSource == DataSource.RESOURCE_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true;
        }

        @Override // com.kwad.sdk.glide.load.engine.h
        public boolean b() {
            return true;
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public static final h f10219b = new h() { // from class: com.kwad.sdk.glide.load.engine.h.2
        @Override // com.kwad.sdk.glide.load.engine.h
        public boolean a() {
            return false;
        }

        @Override // com.kwad.sdk.glide.load.engine.h
        public boolean a(DataSource dataSource) {
            return false;
        }

        @Override // com.kwad.sdk.glide.load.engine.h
        public boolean a(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return false;
        }

        @Override // com.kwad.sdk.glide.load.engine.h
        public boolean b() {
            return false;
        }
    };
    public static final h c = new h() { // from class: com.kwad.sdk.glide.load.engine.h.3
        @Override // com.kwad.sdk.glide.load.engine.h
        public boolean a() {
            return false;
        }

        @Override // com.kwad.sdk.glide.load.engine.h
        public boolean a(DataSource dataSource) {
            return (dataSource == DataSource.DATA_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true;
        }

        @Override // com.kwad.sdk.glide.load.engine.h
        public boolean a(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return false;
        }

        @Override // com.kwad.sdk.glide.load.engine.h
        public boolean b() {
            return true;
        }
    };
    public static final h d = new h() { // from class: com.kwad.sdk.glide.load.engine.h.4
        @Override // com.kwad.sdk.glide.load.engine.h
        public boolean a() {
            return true;
        }

        @Override // com.kwad.sdk.glide.load.engine.h
        public boolean a(DataSource dataSource) {
            return false;
        }

        @Override // com.kwad.sdk.glide.load.engine.h
        public boolean a(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return (dataSource == DataSource.RESOURCE_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true;
        }

        @Override // com.kwad.sdk.glide.load.engine.h
        public boolean b() {
            return false;
        }
    };
    public static final h e = new h() { // from class: com.kwad.sdk.glide.load.engine.h.5
        @Override // com.kwad.sdk.glide.load.engine.h
        public boolean a() {
            return true;
        }

        @Override // com.kwad.sdk.glide.load.engine.h
        public boolean a(DataSource dataSource) {
            return dataSource == DataSource.REMOTE;
        }

        @Override // com.kwad.sdk.glide.load.engine.h
        public boolean a(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return ((z && dataSource == DataSource.DATA_DISK_CACHE) || dataSource == DataSource.LOCAL) && encodeStrategy == EncodeStrategy.TRANSFORMED;
        }

        @Override // com.kwad.sdk.glide.load.engine.h
        public boolean b() {
            return true;
        }
    };

    public abstract boolean a();

    public abstract boolean a(DataSource dataSource);

    public abstract boolean a(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy);

    public abstract boolean b();
}
