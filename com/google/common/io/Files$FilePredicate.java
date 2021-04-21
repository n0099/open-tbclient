package com.google.common.io;

import d.h.c.a.o;
import d.h.c.e.a;
import java.io.File;
/* loaded from: classes6.dex */
public enum Files$FilePredicate implements o<File> {
    IS_DIRECTORY { // from class: com.google.common.io.Files$FilePredicate.1
        @Override // java.lang.Enum
        public String toString() {
            return "Files.isDirectory()";
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.io.Files$FilePredicate, d.h.c.a.o
        public boolean apply(File file) {
            return file.isDirectory();
        }
    },
    IS_FILE { // from class: com.google.common.io.Files$FilePredicate.2
        @Override // java.lang.Enum
        public String toString() {
            return "Files.isFile()";
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.io.Files$FilePredicate, d.h.c.a.o
        public boolean apply(File file) {
            return file.isFile();
        }
    };

    @Override // d.h.c.a.o
    public abstract /* synthetic */ boolean apply(T t);

    /* synthetic */ Files$FilePredicate(a aVar) {
        this();
    }
}
