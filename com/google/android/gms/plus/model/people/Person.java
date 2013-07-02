package com.google.android.gms.plus.model.people;

import com.google.android.gms.common.data.Freezable;
/* loaded from: classes.dex */
public interface Person extends Freezable {

    /* loaded from: classes.dex */
    public interface AgeRange extends Freezable {
    }

    /* loaded from: classes.dex */
    public interface Collection {
    }

    /* loaded from: classes.dex */
    public interface Cover extends Freezable {

        /* loaded from: classes.dex */
        public interface CoverInfo extends Freezable {
        }

        /* loaded from: classes.dex */
        public interface CoverPhoto extends Freezable {
        }

        /* loaded from: classes.dex */
        public final class Layout {
            private Layout() {
            }
        }
    }

    /* loaded from: classes.dex */
    public interface Emails extends Freezable {

        /* loaded from: classes.dex */
        public final class Type {
            private Type() {
            }
        }
    }

    /* loaded from: classes.dex */
    public final class Gender {
        private Gender() {
        }
    }

    /* loaded from: classes.dex */
    public interface Image extends Freezable {
    }

    /* loaded from: classes.dex */
    public interface Name extends Freezable {
    }

    /* loaded from: classes.dex */
    public final class ObjectType {
        private ObjectType() {
        }
    }

    /* loaded from: classes.dex */
    public interface OrderBy {
    }

    /* loaded from: classes.dex */
    public interface Organizations extends Freezable {

        /* loaded from: classes.dex */
        public final class Type {
            private Type() {
            }
        }
    }

    /* loaded from: classes.dex */
    public interface PlacesLived extends Freezable {
    }

    /* loaded from: classes.dex */
    public final class RelationshipStatus {
        private RelationshipStatus() {
        }
    }

    /* loaded from: classes.dex */
    public interface Urls extends Freezable {

        /* loaded from: classes.dex */
        public final class Type {
            private Type() {
            }
        }
    }
}
